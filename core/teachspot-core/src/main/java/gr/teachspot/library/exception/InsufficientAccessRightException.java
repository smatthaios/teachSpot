package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link gr.teachspot.library.exception.InsufficientAccessRightException} must be thrown when someone is trying to perform unauthorised actions. */
public class InsufficientAccessRightException extends SecurityException {
	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.InsufficientAccessRightException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public InsufficientAccessRightException(String message) {
		super(message);
		this.faultReason = FaultReason.INSUFFICIENT_ACCESS_RIGHT;
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.InsufficientAccessRightException}.
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public InsufficientAccessRightException(String message, Throwable exception) {
		super(message, exception);
		this.faultReason = FaultReason.INSUFFICIENT_ACCESS_RIGHT;
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
