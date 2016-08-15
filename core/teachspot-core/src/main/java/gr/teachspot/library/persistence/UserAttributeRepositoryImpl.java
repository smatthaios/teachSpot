package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.UserAttribute;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * The type UserAttribute repository impl contains all {@link UserAttribute} related database actions.
 */
@Repository
public class UserAttributeRepositoryImpl extends AbstractRepository implements UserAttributeRepository {

    /**
     * {@link NamedParameterJdbcTemplate}
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int save(UserAttribute userAttribute) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", userAttribute);

            return namedParameterJdbcTemplate.update(getSqlCommand("USER_ATTRIBUTE_VALUE.INSERT"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during inserting a UserAttribute",
                    userAttribute), ex);
        }
    }
}
