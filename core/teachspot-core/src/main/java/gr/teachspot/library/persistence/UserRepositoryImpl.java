package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.User;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

	/**
	 * Instantiates a new User repository impl.
	 */
	public UserRepositoryImpl() {
	}

	/** {@inheritDoc} */
	@Override
	public List<User> findByAccount(String accountId) {
		return new ArrayList<User>();
	}

	/** {@inheritDoc} */
	@Override
	public User find(Long userId) {
		try {
			final MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("value", userId);
			ParameterizedRowMapper <User> mapper = new ParameterizedRowMapper<User>() {
				@Override
				public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {
					User user = new User();
					user.setId(rs.getString(1));
					user.setEmail(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setFirstName(rs.getString(4));
					user.setLastName(rs.getString(5));
					user.setPasswordToken(rs.getString(6));
					return user;
				}
			};
			return namedParameterJdbcTemplate.queryForObject(getSqlCommand("USER.ID.SELECT"), source, mapper);
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during getting User for [id:%s]",
					userId), ex);
		}
	}

	/** {@inheritDoc} */
	@Override
	public List<User> find(String attribute, String username) {
		try {
			final MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("attribute", attribute);
			source.addValue("value", username);
			ParameterizedRowMapper mapper = new ParameterizedRowMapper() {
				@Override
				public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {
					User user = new User();
					user.setId(rs.getString(1));
					user.setEmail(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setFirstName(rs.getString(4));
					user.setLastName(rs.getString(5));
					user.setPasswordToken(rs.getString(6));
					return user;
				}
			};
			return namedParameterJdbcTemplate.query(getSqlCommand("USER.ATTRIBUTE.SELECT"), source, mapper);
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during getting User for [username:%s] and [attribute:%s]",
					username, attribute), ex);
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
}
