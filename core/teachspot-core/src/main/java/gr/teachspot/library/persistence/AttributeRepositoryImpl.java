package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * The type Attribute repository impl contains all {@link Attribute} related database actions.
 */
@Repository
public class AttributeRepositoryImpl extends AbstractRepository implements AttributeRepository {

	/** {@link NamedParameterJdbcTemplate} */
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Instantiates a new Attribute repository impl.
	 */
	public AttributeRepositoryImpl() {
	}
}
