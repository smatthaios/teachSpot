package gr.teachspot.library.service;

import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.domain.User;
import gr.teachspot.library.enumeration.NotificationType;
import gr.teachspot.library.enumeration.SupportedLanguage;
import gr.teachspot.library.exception.DataException;
import gr.teachspot.library.exception.EmailException;
import gr.teachspot.library.exception.IOException;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;


/** This class is the implementation of the {@link gr.teachspot.library.service.EmailService} interface. It also contains methods to initialize and prepare mails */
@Service
public class EmailServiceImpl implements EmailService {
    /** The LOGGER. */
    private Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    /** The free marker configuration object. */
    @Autowired
    private Configuration freeMarkerConfigurer;

    @Autowired
    private MessageSource messageSource;

    /** The constant PASSWORD_REMINDER_EMAIL_TEMPLATE. */
    private final static String PASSWORD_REMINDER_EMAIL_TEMPLATE = "email/passwordReminder.ftl";
    private final static String USER_REGISTRATION_EMAIL_TEMPLATE = "email/userRegistration.ftl";
    private final static String PAIR_REQUEST_EMAIL_TEMPLATE = "email/pairRequest.ftl";

    @Value("${email.host}")
    private String host;
    @Value("${email.port}")
    private Integer port;
    @Value("${email.username}")
    private String username;
    @Value("${email.password}")
    private String password;
    @Value("${email.tlsEnabled}")
    private Boolean tlsEnabled;
    @Value("${email.sender}")
    private String sender;
    @Value("${email.sender.name}")
    private String senderName;
    @Value("${email.encoding}")
    private String encoding;
    @Value("${email.pairRequestUrl}")
    private String pairRequestUrl;

    /** {@inheritDoc} */
    @Override
    public void sendNotification(final User user, final Lesson lesson, final String hashToken, NotificationType notification) throws IOException {
        initializePairRequestEmail(PAIR_REQUEST_EMAIL_TEMPLATE, user,  lesson,  hashToken, "message.pairRequestSubject");
    }

    /** {@inheritDoc} */
    @Override
    public void sendPasswordReminder(final User user) throws IOException {
        initializeEmail(PASSWORD_REMINDER_EMAIL_TEMPLATE, user, "message.resetPasswordSubject");
    }

    /** {@inheritDoc} */
    @Override
    public void sendUserRegistration(final User user) throws IOException{
        initializeEmail(USER_REGISTRATION_EMAIL_TEMPLATE, user, "message.userRegistrationSubject");
    }

    /**
     * Initialize Email method that creates the email to be sent.
     *
     * @param template the template of the email
     * @param user the {@link gr.teachspot.library.domain.User} to which the email will be sent
     * @param subject  the emails subject
     *
     * @throws gr.teachspot.library.exception.IOException If there was a problem while sending the email.
     * @throws gr.teachspot.library.exception.DataException If there was a problem while creating the email.
     */
    private void initializeEmail(String template, User user, String subject) throws IOException, DataException{
        try {
            final Map<String, Object> templateParameters = prepareTemplateParameters();

            templateParameters.put("token", user.getPasswordToken());
            templateParameters.put("firstName", user.getFirstName());
            templateParameters.put("lastName", user.getLastName());

            final String messageBody = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getTemplate
                    (template), templateParameters);

            sendEmail(messageSource.getMessage(subject, null, SupportedLanguage.getDefault().getLocale()), messageBody,
                    user.getEmail());
        } catch (java.io.IOException | TemplateException ex) {
            LOGGER.debug(ex.toString());
            LOGGER.debug(ex.getMessage());
            throw new DataException(String.format("There was a problem while creating email for User[%s] and template[%s]", user.getId(), template), ex);
        }
    }

    /**
     * Initialize a pair request Email method that creates the email to be sent.
     *
     * @param template the template of the email.
     * @param user the {@link gr.teachspot.library.domain.User} to which the email will be sent.
     * @param user the {@link gr.teachspot.library.domain.Lesson} to pair with.
     * @param subject  the emails subject
     *
     * @throws gr.teachspot.library.exception.IOException If there was a problem while sending the email.
     * @throws gr.teachspot.library.exception.DataException If there was a problem while creating the email.
     */
    private void initializePairRequestEmail(String template, User user, Lesson lesson, String hashToken, String subject) throws IOException, DataException{
        try {
            final Map<String, Object> templateParameters = prepareTemplateParameters();

            templateParameters.put("token", hashToken);
            templateParameters.put("pairRequestUrl", pairRequestUrl);
            templateParameters.put("firstName", user.getFirstName());
            templateParameters.put("lastName", user.getLastName());
            templateParameters.put("lessonName", lesson.getName());

            final String messageBody = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getTemplate
                    (template), templateParameters);

            sendEmail(messageSource.getMessage(subject, null, SupportedLanguage.getDefault().getLocale()), messageBody,
                    user.getEmail());
        } catch (java.io.IOException | TemplateException ex) {
            LOGGER.debug(ex.toString());
            LOGGER.debug(ex.getMessage());
            throw new DataException(String.format("There was a problem while creating email for User[%s] and template[%s]", user.getId(), template), ex);
        }
    }

    /**
     * Utility method that dispatches email messages.
     *
     * @param subject     the subject of the email
     * @param messageBody the message body to be dispatched
     * @param recipients  the recipients of the mail
     *
     * @throws gr.teachspot.library.exception.IOException If there was a problem while sending the email.
     */
    private void sendEmail(final String subject, final String messageBody, final String recipients) throws IOException{
        try {
            final String[] addresses = StringUtils.commaDelimitedListToStringArray(recipients);

            final Email email = prepareEmail();

            email.setMsg(messageBody);
            email.setSubject(subject);
            email.addTo(addresses);

            email.send();
        } catch (final org.apache.commons.mail.EmailException ex) {
            throw new EmailException(String.format("Exception while sending email to the following recipients [%s].", recipients));
        }
    }

    /**
     * Prepares a map of key-value elements, to be used while assembling email body message.
     *
     * @return the map of parameters
     *
     * @throws gr.teachspot.library.exception.DataException if the templates encoding is not valid
     */
    private Map<String, Object> prepareTemplateParameters() throws DataException{
        final Map<String, Object> model = new HashMap<>();
        try{
            model.put("encoding", encoding);
        } catch(RuntimeException re){
            throw new DataException(String.format("There was a problem while creating email template for encoding[%s]", encoding), re);
        }

        return model;
    }

    /**
     * Instantiates an {@link org.apache.commons.mail.Email}, to be used for sending email or SMS messages.
     *
     * @return the email entity
     *
     * @throws gr.teachspot.library.exception.DataException if the port, sender or encoding is not valid
     */
    private Email prepareEmail() throws DataException {

        final Email email = new HtmlEmail();

        try {
            email.setHostName(host);
            email.setSmtpPort(port);

            if (StringUtils.hasText(username) && StringUtils.hasText(password)) {
                email.setAuthenticator(new DefaultAuthenticator(username, password));
            }
            email.setSSLOnConnect(tlsEnabled);
            email.setFrom(sender, senderName);
            email.setCharset(encoding);
            email.setStartTLSEnabled(tlsEnabled);
        } catch(IllegalArgumentException | org.apache.commons.mail.EmailException ex){
            throw new DataException(String.format("There was a problem while preparing the email for port[%s], sender[%s] and encoding[%s]", port, sender, encoding), ex);
        }

        return email;
    }
}
