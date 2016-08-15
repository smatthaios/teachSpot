package gr.teachspot.library.enumeration;

/** This enumeration contains all session related attributes. It is mainly used for organization and single point of reference purposes. */
public enum SessionAttribute {
    /** The session attribute to store the currently logged-in user id. */
	ACTIVE_USER_ID,
    /** The session attribute to store the currently logged-in user profile Id. */
	ACTIVE_USER_PROFILE_ID,
	/** The session attribute to store the session's active language. */
	ACTIVE_LANGUAGE,
	/** The session attribute to store the currently logged-in user name. */
	ACTIVE_USER_NAME,
    /** The session attribute to store the List of country, brand and category id's that belong to the currently logged-in user. */
	ACTIVE_USER_AVAILABLE_CBC_LIST,
    /** The session attribute to store the active currency symbol. */
    ACTIVE_CURRENCY_SYMBOL,
    /** The session attribute to store the active currency of the data the user sees. */
    ACTIVE_CURRENCY
}