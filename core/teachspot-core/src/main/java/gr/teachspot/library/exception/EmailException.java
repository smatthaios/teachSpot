package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link EmailException} must be thrown when an error occurred while sending the email */
public class EmailException extends ApplicationException {

    /** The {@link gr.teachspot.library.enumeration.FaultReason} object representing the cause of the application error. */
    private FaultReason faultReason;

    /**
     * Instantiates a new {@link EmailException}.
     *
     * @param message the message that contains information about the raised exception
     */
    public EmailException(String message) {
        super(message);
        this.faultReason = FaultReason.MAIL_PREPARATION_FAILURE;
    }

    /**
     * Instantiates a new {@link EmailException}.
     *
     * @param message   the message that contains information about the raised exception
     * @param exception the exception that has caused this exception
     */
    public EmailException(String message, Throwable exception) {
        super(message, exception);
        this.faultReason = FaultReason.MAIL_PREPARATION_FAILURE;
    }

    /**
     * Gets the {@link gr.teachspot.library.enumeration.FaultReason} object representing the cause of the application error.
     *
     * @return the {@link gr.teachspot.library.enumeration.FaultReason} object representing the cause of the application error
     */
    public FaultReason getFaultReason() {
        return faultReason;
    }
}
