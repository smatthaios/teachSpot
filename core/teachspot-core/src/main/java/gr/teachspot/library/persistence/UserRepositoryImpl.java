package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.User;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User repository impl contains all {@link User} related database actions.
 */
@Repository
public class UserRepositoryImpl extends AbstractRepository implements UserRepository {

	/** {@link NamedParameterJdbcTemplate} */
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/** {@inheritDoc} */
	@Override
	public List<User> findByAccount(String accountId) {
		return new ArrayList<>();
	}

	/** {@inheritDoc} */
	@Override
	public User find(Long userId) {
		try {
			final MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("value", userId);
			return namedParameterJdbcTemplate.queryForObject(getSqlCommand("USER.ID.SELECT"), source, getUserRowMapper());
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during getting User for [id:%s]",
					userId), ex);
		}
	}

	/** {@inheritDoc} */
	@Override
	public List<User> find(String attribute, String value) {
		try {
			final MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("value", value);
			return namedParameterJdbcTemplate.query(getSqlCommand("USER.ATTRIBUTE.SELECT").replace(":attribute", attribute), source, getUserRowMapper());
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during retrieving Users with [attribute:%s] and [value:%s]",
                    attribute, value), ex);
		}
	}

	/** {@inheritDoc} */
	@Override
	public User update(User user) {
		try {
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			namedParameters.addValue("user_id", Integer.parseInt(user.getId()));
			namedParameters.addValue("email", user.getEmail());
			namedParameters.addValue("password", user.getPassword());
			namedParameters.addValue("first_name", user.getFirstName());
			namedParameters.addValue("last_name", user.getLastName());
			namedParameterJdbcTemplate.update(getSqlCommand("USER.UPDATE"), namedParameters);
		} catch (final Exception ex) {
			throw new DataException(String.format("Error while updating User for [id:%s]",
					user.getId()), ex);
		}

		return user;
	}

	private RowMapper<User> getUserRowMapper() {
		return (rs, rowNum) -> {
			User user = new User();
			user.setId(rs.getString(1));
			user.setEmail(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setFirstName(rs.getString(4));
			user.setLastName(rs.getString(5));
			user.setPasswordToken(rs.getString(6));
			return user;
		};
	}

	@Override
	public int save(User user) {
		try {
			final MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("value", user);

			return namedParameterJdbcTemplate.update(getSqlCommand("USER.INSERT"), source);
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during inserting a User",
					user), ex);
		}
	}
}
