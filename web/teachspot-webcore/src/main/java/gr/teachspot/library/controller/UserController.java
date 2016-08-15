package gr.teachspot.library.controller;

import gr.teachspot.library.domain.User;
import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.enumeration.ResponseStatus;
import gr.teachspot.library.enumeration.SessionAttribute;
import gr.teachspot.library.exception.DataException;
import gr.teachspot.library.exception.IOException;
import gr.teachspot.library.exception.SecurityException;
import gr.teachspot.library.exception.ValidationException;
import gr.teachspot.library.service.UserService;
import gr.teachspot.library.transport.Response;
import gr.teachspot.library.transport.UserDto;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/** The {@link UserController} contains all {@link User} related methods (authenticate, retrieve etc). */
@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {
	/** The prefix to be used for performance statistics */
	private static final String MODULE = "User";

	/** The LOGGER. */
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The UserService. */
	@Autowired
	private UserService userService;

	/**
	 * This method creates a {@link User}.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param accountId the account id
	 * @param email     the email
	 * @param role      the role ( )
	 * @param status    the status ( )
	 * @return the response
	 * @throws DataException when user creation fails
	 */
	/*@RequestMapping(method = RequestMethod.POST)
	public Response<User> create(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final String accountId,
								 @RequestParam final String email, @RequestParam final String role, @RequestParam final String status) throws
			DataException, SecurityException, IOException {
		LOGGER.info("User[firstName:{},lastName:{},email:{},accountId:{},status:{},role:{}].", firstName, lastName, email, accountId, status, role);

		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		User user = userService.create(firstName, lastName, accountId, email, Profile.valueOf(role), UserStatus.valueOf(status));

		stopWatch.stop(MODULE + "create");
		return new Response<>(Arrays.asList(user), ResponseStatus.OK);
	}*/

	/**
	 * This method creates a {@link User}.
	 *
	 * @param userDto the {@link UserDto}
	 * @return the response
	 * @throws DataException when user creation fails
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response<User> create(@RequestParam final UserDto userDto) throws
			DataException, SecurityException, IOException {
		LOGGER.info("User[firstName:{},lastName:{},email:{},ProfileType:{},status:{}].", userDto.getUser().getFirstName(), userDto.getUser().getLastName(), userDto.getUser().getEmail(),
				userDto.getUser().getProfile().getType().name(), userDto.getUser().getStatus());

		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		User user = userService.create(userDto.getUser(), userDto.getAttributeList(), userDto.getProfileType());

		stopWatch.stop(MODULE + "create");
		return new Response<>(Arrays.asList(user), ResponseStatus.OK);
	}

	/**
	 * Authenticates a {@link User} by checking if the given credentials are correct. If {@link User} is authenticated then email is added in the
	 * session.
	 *
	 * @param session  the object in order to save the authenticated
	 * @param username the username
	 * @param password the password
	 * @return the containing the authenticated
	 * @throws SecurityException when authentication fails
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "action=authenticate")
	public Response<User> authenticate(final HttpSession session, @RequestParam final String username, @RequestParam final String password) throws
			SecurityException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		User user = userService.authenticate(username, password);
		session.setAttribute(SessionAttribute.ACTIVE_USER_ID.name(), user.getId());

		stopWatch.stop(MODULE + "authenticate");
		return new Response<>(Arrays.asList(user), ResponseStatus.OK);
	}

	/**
	 * Retrieves active {@link User}.
	 *
	 * @param request the request
	 * @return the response
	 * @throws SecurityException when no active is found at session
	 */
	@RequestMapping(value = "active")
	public Response<User> loadActiveUser(HttpServletRequest request) throws SecurityException {
		return new Response<>(Arrays.asList(super.getActiveUser(request)), ResponseStatus.OK);
	}

	/**
	 * Updates the active user's profile.
	 *
	 * @param request          the request
	 * @param userId       	   the user id
	 * @param firstName        the first name
	 * @param lastName         the last name
	 * @return the updated
	 * @throws DataException if update fails
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "action=updateProfile")
	public Response<User> updateProfile(final HttpServletRequest request, @RequestParam final Long userId, @RequestParam final String firstName,
										@RequestParam final String lastName) throws
			DataException {
		LOGGER.info("User[id:{}] updating profile to [firstName:{},lastName:{}].", userId,
				firstName, lastName);

		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		User user = userService.update(userId, firstName, lastName);

		stopWatch.stop(MODULE + "updateProfile");
		return new Response<>(Arrays.asList(user), ResponseStatus.OK);
	}

	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public Response<User> find(@PathVariable final Long userId) throws
			DataException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		LOGGER.info("Find User[id:{}] by Id]", userId);

		User user = userService.find(userId);

		stopWatch.stop(MODULE + "find");
		return new Response<>(Arrays.asList(user), ResponseStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Response<User> find(@RequestParam("username") final String username) throws
			DataException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		LOGGER.info("Find User[id:{}] by username]", username);

		User user = userService.find(username);

		stopWatch.stop(MODULE + "find");
		return new Response<>(Arrays.asList(user), ResponseStatus.OK);
	}

	/**
	 * Updates specific {@link User fields}
	 *
	 * @param userId    the user id
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param accountId the account id
	 * @param status    the status
	 * @param role      the role
	 * @return the updated
	 * @throws DataException if update fails
	 */
	/*@RequestMapping(value = "{userId}", method = RequestMethod.POST, headers = "action=update")
	public Response<User> update(@PathVariable String userId, @RequestParam final String firstName, @RequestParam final String lastName,
								 @RequestParam final String accountId, @RequestParam final String status, @RequestParam final String role) throws
			DataException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		LOGGER.info("User[id:{}] updating to [firstName:{},lastName:{},accountId:{},status:{},role:{}].", userId, firstName, lastName, accountId,
				status, role);

		User user = userService.findOne(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAccountId(accountId);
		user.setStatus(UserStatus.valueOf(status));
		user.setRole(Profile.valueOf(role));
		userService.save(user);

		stopWatch.stop(MODULE + "update");
		return new Response<>(Arrays.asList(user), ResponseStatus.OK);
	}*/

	/**
	 * De-activate specific {@link User fields}
	 *
	 * @param email the user email
	 * @return the updated
	 * @throws DataException if update fails
	 */
	/*@RequestMapping(method = RequestMethod.POST, headers = "action=deactivate")
	public Response<User> deActivate(@RequestParam String email) throws
			DataException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		LOGGER.info("Deactivating User with [email:{}] ].", email);

		User user = userService.deactivate(email);

		stopWatch.stop(MODULE + "deactivate");
		return new Response<>(Arrays.asList(user), ResponseStatus.OK);
	}*/

	/**
	 * This method deletes a {@link gr.teachspot.library.domain.User}
	 *
	 * @param userId the user id
	 * @return success response if the user us successfully deleted
	 * @throws DataException if deletion fails
	 */
	/*@RequestMapping(method = RequestMethod.POST, headers = "action=delete")
	public Response<String> delete(@RequestParam final String userId) throws DataException {
		LOGGER.info("User[id:{}] is being removed from the system.", userId);

		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		userService.delete(userId);

		stopWatch.stop(MODULE + "delete");
		return new Response<>(null, ResponseStatus.OK);
	}*/

	/**
	 * Initiates the reset password procedure by sending an email to the provided email account, with specific instructions.
	 *
	 * @param email the email
	 * @return a success response mail is sent successfully
	 * @throws DataException if reset password process fails
	 */
	/*@RequestMapping(method = RequestMethod.POST, headers = "action=resetPassword")
	public Response<String> resetPassword(@RequestParam final String email) throws DataException, IOException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		userService.resetPassword(email.trim());

		stopWatch.stop(MODULE + "resetPassword");
		return new Response<>(null, ResponseStatus.OK);
	}*/

	/**
	 * Change password after reset.
	 *
	 * @param passwordToken the password token
	 * @param newPassword   the new password
	 * @return the response
	 * @throws DataException if password change process fails
	 */
	/*@RequestMapping(method = RequestMethod.POST, headers = "action=recover")
	public Response<String> changePasswordAfterReset(@RequestParam final String passwordToken, @RequestParam final String newPassword) throws
			DataException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		userService.changePasswordAfterReset(passwordToken, newPassword);

		stopWatch.stop(MODULE + "changePasswordAfterReset");
		return new Response<>(null, ResponseStatus.OK);
	}*/

	/**
	 * This method is used to change a user's password.
	 *
	 * @param request     the request
	 * @param oldPassword the old password
	 * @param newPassword the new password
	 * @return a success response if the password is updated successfully
	 * @throws ValidationException if old password is not correct
	 */
	/*@RequestMapping(method = RequestMethod.POST, headers = "action=changePassword")
	public Response<String> changePassword(final HttpServletRequest request, @RequestParam final String oldPassword,
										   @RequestParam final String newPassword) throws ValidationException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		userService.changePassword(getActiveUserId(request), oldPassword, newPassword);

		stopWatch.stop(MODULE + "changePassword");
		return new Response<>(null, ResponseStatus.OK);
	}*/

	/**
	 * Retrieves all {@link gr.teachspot.library.domain.User users}
	 *
	 * @return a list of
	 * @throws DataException if retrieval fails
	 */
	/*@RequestMapping(method = RequestMethod.GET)
	public Response<User> getAll() throws DataException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();

		final List<User> users = userService.findAll();
		stopWatch.stop(MODULE + "getAll");

		return new Response<>(users, ResponseStatus.OK);
	}*/

	/**
	 * Find the users associated with the given account.
	 *
	 * @param accountId the account id
	 * @return a list of
	 * @throws DataException if retrieval fails
	 */
	/*@RequestMapping(method = RequestMethod.GET, value = "/account/{accountId}")
	public Response<User> findByAccount(@PathVariable final String accountId) throws DataException {
		final Slf4JStopWatch stopWatch = new Slf4JStopWatch();
		final List<User> users = userService.findByAccount(accountId);
		stopWatch.stop(MODULE + "findByAccount");
		return new Response<>(users, ResponseStatus.OK);
	}*/
}
