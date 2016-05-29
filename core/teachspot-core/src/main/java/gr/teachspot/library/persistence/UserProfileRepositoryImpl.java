package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.dto.UserProfile;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * The type User Profile repository impl contains all methods implementations needed to retrieve the relations between {@link gr.teachspot.library.domain.Profile profiles} and  {@link gr.teachspot.library.domain.User users}.
 */
@Repository
public class UserProfileRepositoryImpl extends AbstractRepository implements UserProfileRepository {

	/** {@link org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate} */
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /** {@inheritDoc} */
    @Override
    public List<UserProfile> get(Long userId) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("user_id", userId);
            return namedParameterJdbcTemplate.query(getSqlCommand("USER_PROFILE.USER_ID.SELECT"), source, getUserProfileRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting UserProfile for User[id:%s]",
                    userId), ex);
        }
    }

    /** {@inheritDoc} */
    @Override
    public UserProfile find(Long profileId) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("profile_id", profileId);
            return namedParameterJdbcTemplate.queryForObject(getSqlCommand("USER_PROFILE.PROFILE_ID.SELECT"), source, getUserProfileRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting UserProfile for Profile[id:%s]",
                    profileId), ex);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void save(Long profileId, Long userId) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("user_id", userId);
            source.addValue("profile_id", profileId);

            namedParameterJdbcTemplate.update(getSqlCommand("USER_PROFILE.INSERT"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while inserting the user profile for User[id:%s] and Profile[id:%s]",
                    userId, profileId), ex);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int deleteByUser(Long userId) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("user_id", userId);

            return namedParameterJdbcTemplate.update(getSqlCommand("USER_PROFILE.USER_ID.DELETE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during deleting User Profile for User[id:%s]",
                    userId), ex);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int deleteByProfile(Long profileId) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("profile_id", profileId);

            return namedParameterJdbcTemplate.update(getSqlCommand("USER_PROFILE.PROFILE_ID.DELETE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during deleting User Profile for Profile[id:%s]",
                    profileId), ex);
        }
    }

    private RowMapper<UserProfile> getUserProfileRowMapper() {
        return (rs, rowNum) -> {
            UserProfile userProfile = new UserProfile();
            userProfile.setProfileId(rs.getLong("profile_id"));
            userProfile.setUserId(rs.getLong("user_id"));
            return userProfile;
        };
    }
}
