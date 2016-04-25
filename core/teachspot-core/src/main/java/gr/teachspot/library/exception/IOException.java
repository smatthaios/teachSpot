package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link gr.teachspot.library.exception.IOException} is thrown when I/O errors occur during the different operations. */
public class IOException extends ApplicationException {
	/** The serial version unique identifier. */
	private static final long serialVersionUID = 8876408990295495762L;

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.IOException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public IOException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.IOException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param faultReason a {@link gr.teachspot.library.enumeration.FaultReason} object representing the causes of the application error
	 */
	public IOException(String message, FaultReason faultReason) {
		super(message);
		this.faultReason = faultReason;
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.IOException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param exception   the exception that has caused this exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public IOException(String message, Throwable exception, FaultReason faultReason) {
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
