package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/**
 * The {@link SecurityException} must be thrown when either communication among modules fails or user is unable to be authenticated against the
 * system, due to security reasons.
 */
public class SecurityException extends ApplicationException {
    /** The serial version unique identifier. */
    private static final long serialVersionUID = -1736212122409619229L;

    /**
     * Instantiates a new {@link SecurityException}.
     *
     * @param message the message that contains information about the raised exception
     */
    public SecurityException(String message) {
        super(message);
        this.faultReason = FaultReason.AUTHENTICATION_FAILED;
    }

    /**
     * Instantiates a new {@link SecurityException}.
     *
     * @param message   the message that contains information about the raised exception
     * @param exception the exception that has caused this exception
     */
    public SecurityException(String message, Throwable exception) {
        super(message, exception);
    }

    /**
     * Instantiates a new {@link SecurityException}.
     *
     * @param message     the message that contains information about the raised exception
     * @param faultReason a {@link FaultReason} object representing the causes of the application error
     */
    public SecurityException(String message, FaultReason faultReason) {
        super(message);
        this.faultReason = faultReason;
    }

    /**
     * Instantiates a new {@link SecurityException}.
     *
     * @param message     the message that contains information about the raised exception
     * @param exception   the exception that has caused this exception
     * @param faultReason a {@link FaultReason} object representing the causes of the application error
     */
    public SecurityException(String message, Throwable exception, FaultReason faultReason) {
        super(message, exception);
        this.faultReason = faultReason;
    }

    /**
     * Gets the {@link FaultReason} object representing the causes of the application error.
     *
     * @return the {@link FaultReason} object representing the causes of the application error
     */
    public FaultReason getFaultReason() {
        return faultReason;
    }
}
