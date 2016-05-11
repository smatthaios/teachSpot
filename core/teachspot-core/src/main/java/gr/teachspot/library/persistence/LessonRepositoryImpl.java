package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Lesson repository impl contains all {@link Lesson} related database actions.
 */
@Repository
public class LessonRepositoryImpl extends AbstractRepository implements LessonRepository {

    /**
     * {@link NamedParameterJdbcTemplate}
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public Lesson find(Long lessonId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", lessonId);
            RowMapper<Lesson> mapper = (rs, rowNum) -> {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong(1));
                lesson.setName(rs.getString(2));
                lesson.setDescription(rs.getString(3));
                return lesson;
            };
            return namedParameterJdbcTemplate.queryForObject(getSqlCommand("LESSON.ID.SELECT"), source, mapper);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting Lesson for [id:%s]",
                    lessonId), ex);
        }
    }
}
