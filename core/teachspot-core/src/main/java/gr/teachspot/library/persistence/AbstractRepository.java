package gr.teachspot.library.persistence;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ResourceBundle;

/**
 * The interface Abstract repository contains the common methods to use while retrieving/persisting data from database. .
 */
@NoRepositoryBean
public abstract class AbstractRepository {

	/** The SQL_COMMANDS parameter. */
	private final ResourceBundle SQL_COMMANDS = ResourceBundle.getBundle("sql");

	/** The JDBC template part of the fallback scenario (direct JDBC access). */
	/*@Autowired
	protected NamedParameterJdbcTemplate namedJdbcTemplate;*/

	/** {@link JdbcTemplate} */
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/

	/** Init void. */
	/*@PostConstruct
	public void init() {
		Assert.notNull(namedJdbcTemplate, "Parameter namedJdbcTemplate must not be null.");
		Assert.notNull(jdbcTemplate, "Parameter jdbcTemplate must not be null.");
	}*/

	/**
	 * Retrieves a sql query by it's key from corresponding properties file. Since we are following the approach according to which we are using
	 * QueryDSL to access the data repository, this method is considered part of the fallback scenario(direct JDBC access).
	 *
	 * @param key - the key
	 * @return the sql query
	 */
	public String getSqlCommand(final String key) {
		if (SQL_COMMANDS.containsKey(key)) {
			return SQL_COMMANDS.getString(key);
		}
		return null;
	}
}
