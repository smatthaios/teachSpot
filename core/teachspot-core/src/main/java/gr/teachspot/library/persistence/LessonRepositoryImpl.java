package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * The type Lesson repository impl contains all {@link Lesson} related database actions.
 */
@Repository
public class LessonRepositoryImpl extends AbstractRepository implements LessonRepository {

	/** {@link NamedParameterJdbcTemplate} */
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Instantiates a new Lesson repository impl.
	 */
	public LessonRepositoryImpl() {
	}
}
