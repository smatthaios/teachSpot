package gr.teachspot.library.service;

import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.domain.User;
import gr.teachspot.library.domain.UserAttribute;
import gr.teachspot.library.enumeration.ProfileType;
import gr.teachspot.library.exception.DataException;
import gr.teachspot.library.exception.IOException;
import gr.teachspot.library.exception.InvalidTemplateException;
import gr.teachspot.library.exception.LessonNotFoundException;
import gr.teachspot.library.exception.SecurityException;
import gr.teachspot.library.exception.UserNotFoundException;
import gr.teachspot.library.exception.ValidationException;

import java.util.List;

/** The interface User service contains all the business methods related to a {@link User}. */
public interface UserService {
	/**
	 * Create user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param accountId the account id
	 * @param email the email
	 * @param role the role
	 * @param status the status
	 * @return the created
	 *
	 * @throws SecurityException the iri security exception
	 * @throws IOException the iri iO exception
	 * @throws DataException the iri data exception
	 * @throws InvalidTemplateException the invalid template exception
	 */
	/*User create(String firstName, String lastName, String accountId, String email, Profile role, UserStatus status) throws SecurityException,
			IOException, DataException, ValidationException;*/

	/**
	 * Deactivate {@link User}.
	 *
	 * @param email the {@link User} email
	 * @return the deactivated {@link User}
	 */
	/*User deactivate(String email);*/

	/**
	 * Authenticates a {@link User} with the given credentials.
	 *
	 * @param email    the email
	 * @param password the password
	 * @return the authenticated
	 * @throws SecurityException when authentication fails
	 */
	User authenticate(String email, String password) throws SecurityException;

	/**
	 * Change the password for the given user.
	 *
	 * @param userId      the user id
	 * @param oldPassword the old password
	 * @param newPassword the new password
	 * @throws ValidationException if old password is wrong, or new password does not meet password policy rules.
	 */
	/*void changePassword(String userId, String oldPassword, String newPassword) throws ValidationException;*/

	/**
	 * Update user.
	 *
	 * @param userId           the user id
	 * @param firstName        the first name
	 * @param lastName         the last name
	 * @return the user
	 */
	User update(Long userId, String firstName, String lastName);

	/**
	 * Reset password of the given user.
	 *
	 * @param email the user email
	 *
	 * @throws DataException the iri data exception
	 * @throws IOException the iri iO exception
	 * @throws InvalidTemplateException the invalid template exception
	 */
	/*void resetPassword(String email) throws DataException, IOException, ValidationException;*/

	/**
	 * Find by token.
	 *
	 * @param passwordToken the password token
	 * @return the user
	 */
	/*User findByToken(String passwordToken);*/

	/**
	 * Change password after reset.
	 *
	 * @param passwordToken the password token
	 * @param newPassword   the new password
	 * @throws UserNotFoundException  the user not found exception
	 * @throws ValidationException the iri validation exception
	 */
	/*void changePasswordAfterReset(String passwordToken, String newPassword) throws UserNotFoundException, ValidationException;*/

	/**
	 * Find by account.
	 *
	 * @param accountId the account id
	 * @return the list
	 */
	/*List<User> findByAccount(String accountId);*/

	/**
	 * Return the {@link User} for the provided id.
	 *
	 * @param userId The {@link User} id
	 * @return The {@link User}
     *
     * @throws UserNotFoundException If the {@link User user} wasn't found
	 */
	User find(Long userId) throws UserNotFoundException;

	/**
	 * Return the {@link User} for the provided username.
	 *
	 * @param username The {@link User} username
	 * @return The {@link User}
     *
     * @throws UserNotFoundException If the {@link User user} wasn't found
	 */
	User find(String username) throws UserNotFoundException;

	/**
	 * Create user.
	 *
	 * @param user the {@link User}
	 * @param attributeList the {@link UserAttribute} list
	 * @return the created
	 *
	 * @throws SecurityException the iri security exception
	 * @throws IOException the iri iO exception
	 * @throws DataException the iri data exception
	 * @throws InvalidTemplateException the invalid template exception
	 */
	User create(User user, List<UserAttribute> attributeList, ProfileType profileType) throws SecurityException,
			IOException, DataException, ValidationException;
}
