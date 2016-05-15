package gr.teachspot.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import gr.teachspot.library.enumeration.ProfileType;
import gr.teachspot.library.enumeration.UserStatus;

/**
 * The type {@link User} represents the user entity of the application.
 */
public class User extends LoggableEntity {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -3492918070638942872L;

    /**
     * The firstName of the {@link User}.
     */
    private String firstName;

    /**
     * The lastName of the {@link User}.
     */
    private String lastName;

    /**
     * The password of the {@link User}.
     */
    private String password;

    /**
     * The email of the {@link User}. Used also as the {@link User user's} username.
     */
    private String email;

    /**
     * Unique id, created every time {@link User} initializes password change procedure.
     */
    private String passwordToken;

    /**
     * The Status.
     */
    private UserStatus status;

    /**
     * The User's profile.
     */
    private Profile profile;

    /**
     * The Username.
     */
    private String username;

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
     * Check if this {@link gr.teachspot.library.domain.User user} has administration rights.
     */
    public boolean isAccountAdmin() {
        //return this.profile.getType().name().equals(ProfileType.ADMINISTRATOR);
        return true;
    }

    /**
     * Gets profile.
     *
     * @return the profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Sets profile.
     *
     * @param profile the profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
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
        //return ProfileType.ADMINISTRATOR.equals(profile.getType());
        return true;
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
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public enum FieldName implements ClassField {
        /**
         * Email field name.
         */
        EMAIL("email"),
        /**
         * Username field name.
         */
        USERNAME("username"),
        /**
         * Password token field name.
         */
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

        /**
         * {@inheritDoc}
         */
        @Override
        public String getName() {
            return classField;
        }
    }
}
