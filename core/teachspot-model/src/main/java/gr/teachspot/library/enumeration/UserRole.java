package gr.teachspot.library.enumeration;

/** The enumeration UserRole contains values that indicate the {@link eu.iri.ace.cbm.domain.User user's| role. */
public enum UserRole {
	/** This role indicates that the user is a system administrator. */
	ADMINISTRATOR,
	/**
	 * This role indicates that the user is an account administrator. This user can create users,
	 * categories and has an overall account supervision.
	 */
	ACCOUNTADMIN,
	/** This role indicates that the user is a simple user. */
	USER;
}
