package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * The type Permission repository impl contains all {@link Permission} related database actions.
 */
@Repository
public class PermissionRepositoryImpl extends AbstractRepository implements PermissionRepository {

	/** {@link NamedParameterJdbcTemplate} */
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Instantiates a new Permission repository impl.
	 */
	public PermissionRepositoryImpl() {
	}
}
