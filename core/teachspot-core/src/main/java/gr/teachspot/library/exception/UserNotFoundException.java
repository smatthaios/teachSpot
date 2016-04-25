package gr.teachspot.library.exception;

import gr.teachspot.library.domain.User;
import gr.teachspot.library.enumeration.FaultReason;

/** The {@link gr.teachspot.library.exception.UserNotFoundException} must be thrown when a {@link User} is not found in the user repository. */
public class UserNotFoundException extends DataException {
	/** The {@link gr.teachspot.library.enumeration.FaultReason} object representing the cause of the application error. */
	private FaultReason faultReason;

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.UserNotFoundException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public UserNotFoundException(String message) {
		super(message);
		this.faultReason = FaultReason.USER_NOT_FOUND;
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.UserNotFoundException}.
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public UserNotFoundException(String message, Throwable exception) {
		super(message, exception);
		this.faultReason = FaultReason.USER_NOT_FOUND;
	}

	/**
	 * Gets the {@link FaultReason} object representing the cause of the application error.
	 *
	 * @return the {@link FaultReason} object representing the cause of the application error
	 */
	public FaultReason getFaultReason() {
		return faultReason;
	}
}
