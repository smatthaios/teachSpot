package gr.teachspot.library.exception;

import gr.teachspot.library.enumeration.FaultReason;

/** The {@link gr.teachspot.library.exception.DataCalculationException} must be thrown when an error occurs during any calculation. */
public class DataCalculationException extends DataException {

	/** The serial version unique identifier. */
	private static final long serialVersionUID = 1012377955237880486L;

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DataCalculationException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public DataCalculationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DataCalculationException}
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public DataCalculationException(String message, Throwable exception) {
		super(message, exception);
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DataCalculationException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public DataCalculationException(String message, FaultReason faultReason) {
		super(message);
		this.faultReason = faultReason;
	}

	/**
	 * Instantiates a new {@link gr.teachspot.library.exception.DataCalculationException}.
	 *
	 * @param message     the message that contains information about the raised exception
	 * @param exception   the exception that has caused this exception
	 * @param faultReason a {@link FaultReason} object representing the causes of the application error
	 */
	public DataCalculationException(String message, Throwable exception, FaultReason faultReason) {
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
