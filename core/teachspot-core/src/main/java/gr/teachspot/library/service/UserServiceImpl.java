package gr.teachspot.library.service;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.domain.UserProfileLesson;
import gr.teachspot.library.domain.User;
import gr.teachspot.library.domain.UserAttribute;
import gr.teachspot.library.enumeration.*;
import gr.teachspot.library.exception.*;
import gr.teachspot.library.exception.SecurityException;
import gr.teachspot.library.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type User service impl contains all the business methods related to a {@link User}.
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * Logger to be used
	 */
	private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * The Password encoder used for password encoding purposes.
	 */
	@Autowired
	private Md5PasswordEncoder passwordEncoder;

	/**
	 * The User Repository.
	 */
	@Autowired
	private UserRepository userRepository;

	/** The constant PASSWORD_SALT is used for password encoding. */
	/**
	 * The UserProfile Repository.
	 */
	@Autowired
	private UserProfileRepository userProfileRepository;

	/**
	 * The UserAttribute Repository.
	 */
	@Autowired
	private UserAttributeRepository userAttributeRepository;

	/**
	 * The Profile.
	 */
	@Autowired
	private ProfileRepository profileRepository;

	/**
	 * The Lesson repository.
	 */
	@Autowired
	private LessonRepository lessonRepository;

	/**
	 * The UserProfileLesson repository.
	 */
	@Autowired
	private UserProfileLessonRepository userProfileLessonRepository;

	/*@Autowired
    private EmailService emailService;*/

	/**
	 * The constant PASSWORD_SALT is used for password encoding.
	 */
	private static final String PASSWORD_SALT = "PWD_TS";

	private static final RegularExpression PASSWORD_PATTERN = new RegularExpression("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{6,13}$");

	@Override
	public User create(User user, List<UserAttribute> attributeList, ProfileType profileType) throws SecurityException, IOException, DataException, ValidationException {
		User newUser = new User();
		List<User> users = userRepository.find(User.FieldName.EMAIL.name(), user.getEmail());
		if (users != null && users.size() > 0) {
			throw new UserNotUniqueException(users.get(0).getEmail());
		} else {
			validateUser(user);
			int userId = userRepository.save(user);
			validateUserAttributes(user.getProfile().getType(), attributeList);
			for (UserAttribute userAttribute : attributeList) {
				userAttributeRepository.save(userAttribute);//todo: make it batch
			}

			userProfileRepository.save(profileRepository.find(profileType).getId(), ((Integer)userId).longValue());
			if (profileType.equals(ProfileType.SCHOOL.name())) {
				Long lessonId = lessonRepository.save(new Lesson("default", "This is an empty lesson", SchoolLevel.DEFAULT, Subject.DEFAULT));
				userProfileLessonRepository.save(new UserProfileLesson(user.getProfile().getId(), lessonId));//todo
			}
		}

		return newUser;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User authenticate(String username, String password) throws SecurityException {
		List<User> users = userRepository.find(User.FieldName.EMAIL.name(), username.toLowerCase());

		if (users == null || users.size() == 0 || users.get(0) == null || !getEncodedPassword(password).equals(users.get(0).getPassword())) {
			throw new SecurityException(String.format("User credentials for user %s are not valid.", username), FaultReason.USER_NOT_FOUND);
		}

		if (UserStatus.LOCKED.equals(users.get(0).getStatus())) {
			throw new SecurityException(String.format("User %s is locked.", users.get(0).getUsername()), FaultReason.USER_LOCKED);
		}

		if (UserStatus.INACTIVE.equals(users.get(0).getStatus())) {
			throw new SecurityException(String.format("User %s is inactive.", users.get(0).getUsername()), FaultReason.USER_INACTIVE);
		}
		return users.get(0);
	}

	private void validatePassword(final String newPassword) throws ValidationException {
		if (!PASSWORD_PATTERN.matches(newPassword)) {
			throw new ValidationException(String.format("User password doesn't apply to security policy."),
					FaultReason.USER_WRONG_PASSWORD_POLICY);
		}
	}

	private void validateUser(final User user) throws ValidationException {
		if (user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getPassword() == null)//todo discuss validation
			throw new ValidationException(String.format("User did not provide necessary information. "),
					FaultReason.USER_WRONG_PASSWORD_POLICY);      //todo: add fault reason
	}

	private void validateUserAttributes(final ProfileType profileType, List<UserAttribute> userAttributes) throws ValidationException {
        /*getuserAttributesByprofiletype();
        if()
        if (!PASSWORD_PATTERN.matches(newPassword)) {
            throw new ValidationException(String.format("User password doesn't apply to security policy."),
                    FaultReason.USER_WRONG_PASSWORD_POLICY);
        }*/
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User find(Long userId) throws UserNotFoundException {
		User user = userRepository.find(userId);

		if (user == null) {
			throw new UserNotFoundException(String.format("User wasn't found for [id:%s].", userId));
		}

		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User find(String username) throws UserNotFoundException {
		List<User> users = userRepository.find(User.FieldName.EMAIL.name(), username.toLowerCase());

		if (users == null || users.size() == 0 || users.get(0) == null) {
			throw new SecurityException(String.format("User wasn't found for [username:%s].", username), FaultReason.USER_NOT_FOUND);
		}

		return users.get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User update(Long userId, String firstName, String lastName) {
        User user = find(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return userRepository.update(user);
	}

	/**
	 * Encodes the given password key using MD5 hash encoder.
	 *
	 * @param password the password to be encoded
	 * @return the encoded password
	 */
	private String getEncodedPassword(String password) {
		return passwordEncoder.encodePassword(password, PASSWORD_SALT);
	}
}
