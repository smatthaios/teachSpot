package gr.teachspot.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import gr.teachspot.library.enumeration.UserRole;
import gr.teachspot.library.enumeration.UserStatus;

/** The type {@link User} represents the user entity of the application. */
public class User extends LoggableEntity {
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = -3492918070638942872L;

	/** The firstName of the {@link User}. */
	private String firstName;

	/** The lastName of the {@link User}. */
	private String lastName;

	/** The password of the {@link User}. */
	private String password;

	/** The email of the {@link User}. Used also as the {@link User user's} username. */
	private String email;

	/** Unique id, created every time {@link User} initializes password change procedure. */
	private String passwordToken;

	/** The Status. */
	private UserStatus status;

	/** The Account id. */
	private String accountId;

	/** The Role. */
	private UserRole role;

	/** The Intro enabled. */
	private boolean introEnabled;

	/**
	 * The Default project id.
	 */
	private String defaultProjectId;

	/**
	 * The Username.
	 */
	private String username;

	/**
	 * The Admin.
	 */
	private boolean admin;
	/**
	 * The Account admin.
	 */
	private boolean accountAdmin;

	/**
	 * Gets default project id.
	 *
	 * @return the default project id
	 */
	public String getDefaultProjectId() {
		return defaultProjectId;
	}

	/**
	 * Sets default project id.
	 *
	 * @param defaultProjectId the default project id
	 */
	public void setDefaultProjectId(final String defaultProjectId) {
		this.defaultProjectId = defaultProjectId;
	}

	/**
	 * Gets username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets username.
	 *
	 * @param username the username
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * Is intro enabled.
	 *
	 * @return the boolean
	 */
	public boolean isIntroEnabled() {
		return introEnabled;
	}

	/**
	 * Sets intro enabled.
	 *
	 * @param introEnabled the intro enabled
	 */
	public void setIntroEnabled(final boolean introEnabled) {
		this.introEnabled = introEnabled;
	}

	/**
	 * Gets role.
	 *
	 * @return the role
	 */
	public UserRole getRole() {
		return role;
	}

	public void setAdmin(final boolean admin) {
		this.admin = admin;
	}

	public void setAccountAdmin(final boolean accountAdmin) {
		this.accountAdmin = accountAdmin;
	}

	/**
	 * Sets role.
	 *
	 * @param role the role
	 */
	public void setRole(final UserRole role) {
		this.role = role;
	}

	/**
	 * Gets account id.
	 *
	 * @return the account id
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * Sets account id.
	 *
	 * @param accountId the account id
	 */
	public void setAccountId(final String accountId) {
		this.accountId = accountId;
	}

	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public UserStatus getStatus() {
		return status;
	}

	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(final UserStatus status) {
		this.status = status;
	}

	/**
	 * Gets the firstName of the {@link User}.
	 *
	 * @return the firstName of the
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the firstName of the {@link User}.
	 *
	 * @param firstName the firstName of the
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the lastName of the {@link User}.
	 *
	 * @return the lastName of the
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the lastName of the {@link User}.
	 *
	 * @param lastName the lastName of the
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the password of the {@link User}.
	 *
	 * @return the password of the
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the {@link User}.
	 *
	 * @param password the password of the
	 */
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email of the {@link User}.
	 *
	 * @return the email of the
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the {@link User}.
	 *
	 * @param email the new email of the
	 */
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	/**
	 * Gets unique id, created every time {@link User} resets password.
	 *
	 * @return passwordToken, created every time initializes password change procedure.
	 */
	public String getPasswordToken() {
		return passwordToken;
	}

	/**
	 * Sets unique id, created every time {@link User} resets password.
	 *
	 * @param passwordToken the password token
	 */
	public void setPasswordToken(final String passwordToken) {
		this.passwordToken = passwordToken;
	}

	/**
	 * Is admin.
	 *
	 * @return the boolean
	 */
	public boolean isAdmin() {
		return UserRole.ADMINISTRATOR.equals(role);
	}

	/**
	 * Is account admin.
	 *
	 * @return the boolean
	 */
	public boolean isAccountAdmin() {
		return UserRole.ACCOUNTADMIN.equals(role);
	}

	/**
	 * Checks if this {@link User} is the same with the given {@link User}. Two {@link User users} are considered the same if they have the same
	 * email.
	 *
	 * @param user the {@link User} to be used in the comparison
	 * @return true if this {@link User} has the same email with the given {@link User} or false otherwise
	 */
	@Override
	@JsonIgnore
	public boolean equals(Object user) {
		if (((User) user).getEmail().equals(getEmail())) {
			return true;
		}
		return false;
	}

	/**
	 * Creates the string representation of the {@link gr.teachspot.library.domain.User}.
	 *
	 * @return String representing the {@link gr.teachspot.library.domain.User}
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("firstName='").append(firstName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", passwordToken='").append(passwordToken).append('\'');
		sb.append(", status=").append(status);
		sb.append(", accountId='").append(accountId).append('\'');
		sb.append(", role=").append(role);
		sb.append(", introEnabled=").append(introEnabled);
		sb.append(", defaultProjectId='").append(defaultProjectId).append('\'');
		sb.append(", username='").append(username).append('\'');
		sb.append(", admin=").append(admin);
		sb.append(", accountAdmin=").append(accountAdmin);
		sb.append('}');
		return sb.toString();
	}

	/** {@inheritDoc} */
	public enum FieldName implements ClassField {
		EMAIL("email"),
		USERNAME("username"),
		PASSWORD_TOKEN("passwordToken");

		/**
		 * The Class field.
		 */
		private final String classField;

		/**
		 * Instantiates a new User field name.
		 *
		 * @param classField the class field
		 */
		FieldName(String classField) {
			this.classField = classField;
		}

		/** {@inheritDoc} */
		@Override
		public String getName() {
			return classField;
		}
	}
}
