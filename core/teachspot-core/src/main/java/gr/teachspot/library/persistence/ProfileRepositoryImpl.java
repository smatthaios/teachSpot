package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.User;
import gr.teachspot.library.domain.Profile;
import gr.teachspot.library.enumeration.ProfileType;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

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
            ParameterizedRowMapper<Profile> mapper = (rs, rowNum) -> {
                Profile profile = new Profile();
                profile.setId(rs.getLong(1));
                profile.setType(ProfileType.valueOf(rs.getString(2)));
                return profile;
            };
            return namedParameterJdbcTemplate.queryForObject(getSqlCommand("PROFILE.ID.SELECT"), source, mapper);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting Profile for [id:%s]",
                    profileId), ex);
        }
    }
}
