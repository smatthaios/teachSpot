package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Permission;
import gr.teachspot.library.enumeration.PermissionType;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Permission repository impl contains all {@link Permission} related database actions.
 */
@Repository
public class PermissionRepositoryImpl extends AbstractRepository implements PermissionRepository {

	/** {@link NamedParameterJdbcTemplate} */
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission find(Long permissionId) {
		try {
			final MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("value", permissionId);
			ParameterizedRowMapper<Permission> mapper = new ParameterizedRowMapper<Permission>() {
				@Override
				public Permission mapRow(final ResultSet rs, final int rowNum) throws SQLException {
					Permission permission = new Permission();
					permission.setId(rs.getLong(1));
					permission.setType(PermissionType.valueOf(rs.getString(2)));
					return permission;
				}
			};
			return namedParameterJdbcTemplate.queryForObject(getSqlCommand("PERMISSION.ID.SELECT"), source, mapper);
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during getting Permission for [id:%s]",
					permissionId), ex);
		}
	}
}
