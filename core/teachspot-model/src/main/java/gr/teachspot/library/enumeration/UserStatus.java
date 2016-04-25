package gr.teachspot.library.enumeration;

import gr.teachspot.library.domain.User;

/** The enumeration UserRole contains values that indicate the {@link User user's} status. */
public enum UserStatus {
	/** This role indicates that the user is active. */
	ACTIVE,
	/** This role indicates that the user is not active. */
	INACTIVE,
	/** This role indicates that the user is locked. */
	LOCKED;
}
