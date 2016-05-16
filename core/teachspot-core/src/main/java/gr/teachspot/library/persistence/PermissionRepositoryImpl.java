package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Permission;
import gr.teachspot.library.enumeration.PermissionType;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
			RowMapper<Permission> mapper = (rs, rowNum) -> {
                Permission permission = new Permission();
                permission.setId(rs.getLong("permission_id"));
                permission.setType(PermissionType.valueOf(rs.getString("name")));
                return permission;
            };
			return namedParameterJdbcTemplate.queryForObject(getSqlCommand("PERMISSION.ID.SELECT"), source, mapper);
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during getting Permission for [id:%s]",
					permissionId), ex);
		}
	}

	@Override
	public List<Permission> get(Long profileId) {
		try {
			final MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("value", profileId);
			RowMapper<Permission> mapper = (rs, rowNum) -> {
                Permission permission = new Permission();
                permission.setId(rs.getLong("permission_id"));
                permission.setType(PermissionType.valueOf(rs.getString("name")));
                return permission;
            };
			return namedParameterJdbcTemplate.query(getSqlCommand("PERMISSION.PROFILE_ID.SELECT"), source, mapper);
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during getting Permission for profile [id:%s]",
					profileId), ex);
		}
	}

	@Override
	public int delete(Long permissionId) {
		try {
			final MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("value", permissionId);
			return namedParameterJdbcTemplate.update(getSqlCommand("PERMISSION.DELETE"), source);
		} catch (final Exception ex) {
			throw new DataException(String.format("Error during deleting Permission for [id:%s]",
					permissionId), ex);
		}
	}
}
