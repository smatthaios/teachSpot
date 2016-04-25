package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link InvalidTemplateException} must be thrown when preparation of a Freemarker template fails */
public class InvalidTemplateException extends ValidationException {

	/** serial version UID */
	private static final long serialVersionUID = -1736212122409619229L;

	/**
	 * Instantiates a new {@link InvalidTemplateException}.
	 *
	 * @param message the error message
	 */
	public InvalidTemplateException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link InvalidTemplateException}.
	 *
	 * @param message   the error message
	 * @param exception the exception
	 */
	public InvalidTemplateException(final String message, final Throwable exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new {@link InvalidTemplateException}.
	 *
	 * @param message     the error message
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public InvalidTemplateException(final String message, final FaultReason faultReason) {
		super(message, faultReason);
	}

	/**
	 * Instantiates a new {@link InvalidTemplateException}.
	 *
	 * @param message     the error message
	 * @param exception   the exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public InvalidTemplateException(final String message, final Throwable exception, final FaultReason faultReason) {
		super(message, exception, faultReason);
	}
}
