package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link ApplicationException} is the parent exception for this application. All application specific exceptions MUST extend this class. */
public class ApplicationException extends RuntimeException {
	/** The serial version unique identifier. */
	private static final long serialVersionUID = 8950175273639927330L;

	/** The {@link gr.teachspot.library.enumeration.FaultReason} object representing the cause of the application error. */
	protected FaultReason faultReason;
	/** the arguments needed to be passed as variables on the message */
	protected Object[] args;

	/**
	 * Instantiates a new {@link ApplicationException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link ApplicationException}.
	 *
	 * @param message   he message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public ApplicationException(String message, Throwable exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new {@link ApplicationException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public ApplicationException(String message, FaultReason faultReason) {
		super(message);
		this.faultReason = faultReason;
	}

	/**
	 * Instantiates a new {@link ApplicationException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param exception   the exception that has caused this exception
	 * @param faultReason a {@link FaultReason} object representing the cause of the application error
	 */
	public ApplicationException(String message, Throwable exception, FaultReason faultReason) {
		super(message, exception);
		this.faultReason = faultReason;
	}

	/**
	 * Gets the {@link FaultReason} object representing the cause of the application error.
	 *
	 * @return the {@link FaultReason} object representing the cause of the application error
	 */
	public FaultReason getFaultReason() {
		return faultReason;
	}

	/**
	 * Gets the arguments that needed to be passed as variables on the message
	 *
	 * @return the arguments that needed to be passed as variables on the message
	 */
	public Object[] getArguments() { return args;}
}
