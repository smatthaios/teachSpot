package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link gr.teachspot.library.exception.DBConnectionFailedException} must be thrown when database connection fails. */
public class DBConnectionFailedException extends DataException {
	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DBConnectionFailedException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public DBConnectionFailedException(String message) {
		super(message);
		this.faultReason = FaultReason.DB_CONNECTION_FAILED;
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DBConnectionFailedException}.
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public DBConnectionFailedException(String message, Throwable exception) {
		super(message, exception);
		this.faultReason = FaultReason.DB_CONNECTION_FAILED;
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
