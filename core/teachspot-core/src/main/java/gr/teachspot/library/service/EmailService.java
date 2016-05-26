package gr.teachspot.library.service;

import gr.teachspot.library.domain.User;
import gr.teachspot.library.exception.IOException;

/** This interface hold all methods needed to send emails. */
public interface EmailService {

    /**
     * Sends password reminder message for the given {@link User}.
     * @throws gr.teachspot.library.exception.IOException If there was a problem while sending the email.
     */
    void sendPasswordReminder(final User user) throws IOException;

    /**
     * Send user registration message at the given {@link User}.
     *
     * @param user the {@link gr.teachspot.library.domain.User} to send the message
     * @throws gr.teachspot.library.exception.IOException If there was a problem while sending the email.
     */
    void sendUserRegistration(final User user) throws IOException;

}
