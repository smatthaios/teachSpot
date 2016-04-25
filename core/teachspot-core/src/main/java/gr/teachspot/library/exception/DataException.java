package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link DataException} is thrown when data integrity fails among application. */
public class DataException extends ApplicationException {
	/** The serial version unique identifier. */
	private static final long serialVersionUID = 6074035532046216283L;

	/**
	 * Instantiates a new {@link DataException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public DataException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link DataException}
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public DataException(String message, Throwable exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new {@link DataException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param faultReason a {@link gr.teachspot.library.enumeration.FaultReason} object representing the causes of the application error
	 */
	public DataException(String message, FaultReason faultReason) {
		super(message);
		this.faultReason = faultReason;
	}

	/**
	 * Instantiates a new {@link DataException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param exception   the exception that has caused this exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public DataException(String message, Throwable exception, FaultReason faultReason) {
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
