package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/**
 * The type Session expired exception is used to notify that a session has ended.
 */
public class SessionExpiredException extends SecurityException {
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 2949070628521132272L;

	/**
	 * Instantiates a new Session expired exception.
	 *
	 * @param message the message
	 */
	public SessionExpiredException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new Session expired exception.
	 *
	 * @param message   the message
	 * @param exception the exception
	 */
	public SessionExpiredException(final String message, final Throwable exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new Session expired exception.
	 *
	 * @param message     the message
	 * @param faultReason the fault reason
	 */
	public SessionExpiredException(final String message, final FaultReason faultReason) {
		super(message, faultReason);
	}

	/**
	 * Instantiates a new Session expired exception.
	 *
	 * @param message     the message
	 * @param exception   the exception
	 * @param faultReason the fault reason
	 */
	public SessionExpiredException(final String message, final Throwable exception, final FaultReason faultReason) {
		super(message, exception, faultReason);
	}
}
