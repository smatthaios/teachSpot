package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link UserNotUniqueException} must be thrown when a {@link gr.teachspot.library.domain.User} is not unique in the user repository. */
public class UserNotUniqueException extends DataException {
	/** The {@link gr.teachspot.library.enumeration.FaultReason} object representing the cause of the application error. */
	private FaultReason faultReason;

	/**
	 * Instantiates a new {@link UserNotUniqueException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public UserNotUniqueException(String message) {
		super(message);
		this.faultReason = FaultReason.USERNAME_EXISTS;
	}

	/**
	 * Instantiates a new {@link UserNotUniqueException}.
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public UserNotUniqueException(String message, Throwable exception) {
		super(message, exception);
		this.faultReason = FaultReason.USERNAME_EXISTS;
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
