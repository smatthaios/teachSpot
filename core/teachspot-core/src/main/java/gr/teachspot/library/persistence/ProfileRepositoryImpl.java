package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Profile;
import gr.teachspot.library.enumeration.ProfileType;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.List;


/**
 * The type Profile repository impl contains all {@link Profile} related database actions.
 */
@Repository
public class ProfileRepositoryImpl extends AbstractRepository implements ProfileRepository {

    /**
     * {@link NamedParameterJdbcTemplate}
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public Profile find(Long profileId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", profileId);
            return namedParameterJdbcTemplate.queryForObject(getSqlCommand("PROFILE.ID.SELECT"), source, getProfileRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting Profile for [id:%s]",
                    profileId), ex);
        }
    }


    @Override
    public List<Profile> get(Long userId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", userId);

            return namedParameterJdbcTemplate.query(getSqlCommand("PROFILE.USER_ID.SELECT"), source, getProfileRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting the list of Profiles for User [id:%s]",
                    userId), ex);
        }
    }

    @Override
    public Long save(Profile profile) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("name", profile.getType().toString());

            namedParameterJdbcTemplate.update(getSqlCommand("PROFILE.INSERT"), source, keyHolder);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while inserting a profile",
                    profile.toString()), ex);
        }

        return (Long)keyHolder.getKey();
    }

    @Override
    public int update(Profile profile) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("name", profile.getType().toString());
            source.addValue("profile_id", profile.getId());

            return namedParameterJdbcTemplate.update(getSqlCommand("PROFILE.UPDATE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while updating Profile [id:%s]",
                    profile.getId()), ex);
        }
    }

    @Override
    public int delete(Long profileId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("profile_id", profileId);

            return namedParameterJdbcTemplate.update(getSqlCommand("PROFILE.DELETE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during deleting Profile [id:%s]",
                    profileId), ex);
        }

    }

    private RowMapper<Profile> getProfileRowMapper() {
        return (rs, rowNum) -> {
            Profile profile = new Profile();
            profile.setId(rs.getLong("profile_id"));
            profile.setType(ProfileType.valueOf(rs.getString("name")));
            return profile;
        };
    }
}
