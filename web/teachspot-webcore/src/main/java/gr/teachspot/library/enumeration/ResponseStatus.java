package gr.teachspot.library.enumeration;

/**
 * The Enum ResponseStatus. It is used in order to define specific return codes to be used throughout the application. Enum is preferred over String
 * since it does not allow each developer to enter his own String and risking potential inconsistencies.
 */
public enum ResponseStatus {
	/** The OK status. Used in order to indicate that the specific response is a valid one. */
	OK,
	/** The ERROR status. Used when there is a generated exception or logic error in specific business logic. */
	ERROR,
    /** The WARNING status. Used when there is a generated exception or logic error in specific business logic but isn't fatal for the application. */
    WARNING,
	/** The NOT_FOUND status. Used when there was no corresponding information being found. */
	NOT_FOUND,
	/** Used when the session has expired. */
	SESSION_EXPIRED,
	/** The INVALID_DATA status. Used when service parameters as not aligned with corresponding validation rules. */
	INVALID_DATA
}
