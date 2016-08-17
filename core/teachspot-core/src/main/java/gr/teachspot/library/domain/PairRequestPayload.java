package gr.teachspot.library.domain;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import gr.teachspot.library.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

@Component
public class PairRequestPayload extends Payload {

    /** The LOGGER. */
    private Logger LOGGER = LoggerFactory.getLogger(PairRequestPayload.class);

    /** The free marker configuration object. */
    @Autowired
    private Configuration freeMarkerConfigurer;

    @Value("${email.pairRequestUrl}")
    private String pairRequestUrl;

    private String token;
    private Long profileId;
    private String firstName;
    private String lastName;
    private String lessonName;

    public PairRequestPayload(String templatePath, String encoding, String token, Long profileId, String firstName, String lastName, String lessonName) {

        //TODO: Make ftl dynamic (so that we can use it to get different templates)
        super("email/pairRequest.ftl", encoding);
        this.token = token;
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lessonName = lessonName;
    }

    public String getBody() {
        String messageBody;
        try {
            final Map<String, Object> templateParameters = prepareTemplateParameters();

            templateParameters.put("token", token);
            templateParameters.put("profileId", profileId);
            templateParameters.put("pairRequestUrl", pairRequestUrl);
            templateParameters.put("firstName", firstName);
            templateParameters.put("lastName", lastName);
            templateParameters.put("lessonName", lessonName);

            messageBody = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getTemplate
                    (getTemplatePath()), templateParameters);

        } catch (java.io.IOException | TemplateException ex) {
            LOGGER.debug(ex.toString());
            LOGGER.debug(ex.getMessage());
            throw new DataException(String.format("There was a problem while creating template[%s]", getTemplatePath()), ex);
        }
        return messageBody;
    }
}
