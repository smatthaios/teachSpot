package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link gr.teachspot.library.exception.DataNotFoundException} must be thrown when the application cannot retrieve data that should exist in the DB. */
public class DataNotFoundException extends DataException {

	/** The serial version unique identifier. */
	private static final long serialVersionUID = 6338429693512596487L;

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DataNotFoundException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public DataNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DataNotFoundException}
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public DataNotFoundException(String message, Throwable exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DataNotFoundException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param faultReason a {@link gr.teachspot.library.enumeration.FaultReason} object representing the causes of the application error
	 */
	public DataNotFoundException(String message, FaultReason faultReason) {
		super(message);
		this.faultReason = faultReason;
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DataNotFoundException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param exception   the exception that has caused this exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public DataNotFoundException(String message, Throwable exception, FaultReason faultReason) {
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
