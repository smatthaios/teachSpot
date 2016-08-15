package gr.teachspot.library.exception;

import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.enumeration.FaultReason;

/** The {@link LessonNotFoundException} must be thrown when a {@link Lesson} is not found in the Lesson repository. */
public class LessonNotFoundException extends DataException {
	/** The {@link FaultReason} object representing the cause of the application error. */
	private FaultReason faultReason;

	/**
	 * Instantiates a new {@link LessonNotFoundException}.
	 *
	 * @param message the message that contains information about the raised exception
	 */
	public LessonNotFoundException(String message) {
		super(message);
		this.faultReason = FaultReason.LESSON_NOT_FOUND;
	}

	/**
	 * Instantiates a new {@link LessonNotFoundException}.
	 *
	 * @param message   the message that contains information about the raised exception
	 * @param exception the exception that has caused this exception
	 */
	public LessonNotFoundException(String message, Throwable exception) {
		super(message, exception);
		this.faultReason = FaultReason.LESSON_NOT_FOUND;
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
