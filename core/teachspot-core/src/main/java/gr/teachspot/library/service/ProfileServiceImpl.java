package gr.teachspot.library.service;

import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.domain.Profile;
import gr.teachspot.library.domain.User;
import gr.teachspot.library.domain.dto.UserProfile;
import gr.teachspot.library.enumeration.NotificationType;
import gr.teachspot.library.exception.LessonNotFoundException;
import gr.teachspot.library.exception.UserNotFoundException;
import gr.teachspot.library.persistence.ProfileRepository;
import gr.teachspot.library.persistence.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Profile service impl contains all the business methods related to a {@link gr.teachspot.library.domain.Profile}.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    /**
     * Logger to be used
     */
    private final static Logger LOG = LoggerFactory.getLogger(ProfileServiceImpl.class);

    /**
     * The Lesson Service.
     */
    @Autowired
    private LessonService lessonService;

    /**
     * The Email Service.
     */
    @Autowired
    private EmailService emailService;

    /**
     * The User Service.
     */
    @Autowired
    private UserService userService;

    /**
     * The Profile Repository.
     */
    @Autowired
    private ProfileRepository profileRepository;

    /**
     * The User Profile Repository.
     */
    @Autowired
    private UserProfileRepository userProfileRepository;

    /** The Password encoder used for password encoding purposes. */
    @Autowired
    private Md5PasswordEncoder passwordEncoder;

    /** The constant PASSWORD_SALT is used for password encoding. */
    private static final String PASSWORD_SALT = "PWD_TS";

    /**
     * {@inheritDoc}
     */
    @Override
    public Profile find(Long profileId) {
        return profileRepository.find(profileId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Profile> get(Long userId) {
        return profileRepository.get(userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long save(Profile profile) {
        return profileRepository.save(profile);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(Profile profile) {
        return profileRepository.update(profile);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(Long profileId) {
        return profileRepository.delete(profileId);
    }

    /** {@inheritDoc} */
     @Override
    public void pairRequest(Long profileId, Long lessonId) throws LessonNotFoundException, UserNotFoundException {
        Lesson lesson = lessonService.find(lessonId);

         UserProfile userProfile = userProfileRepository.find(profileId);
         User user = userService.find(userProfile.getUserId());

        String hashToken = getEncodedPassword(user.getEmail() + lesson.getId());
        emailService.sendNotification(user, lesson, hashToken, NotificationType.PAIR_REQUEST);
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
