package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link ValidationException} must be thrown when validations fail among application. */
public class ValidationException extends ApplicationException {
	/** The serial version unique identifier. */
	private static final long serialVersionUID = -1736212122409619229L;

	/**
	 * Instantiates a new {@link ValidationException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link ValidationException}.
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public ValidationException(String message, Throwable exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new {@link ValidationException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public ValidationException(String message, FaultReason faultReason) {
		super(message);
		this.faultReason = faultReason;
	}

	/**
	 * Instantiates a new {@link ValidationException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param exception   the exception that has caused this exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public ValidationException(String message, Throwable exception, FaultReason faultReason) {
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
