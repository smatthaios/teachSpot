package gr.teachspot.library.service;


import gr.teachspot.library.domain.Profile;
import gr.teachspot.library.persistence.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
     * The Profile Repository.
     */
    @Autowired
    private ProfileRepository profileRepository;

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


}
