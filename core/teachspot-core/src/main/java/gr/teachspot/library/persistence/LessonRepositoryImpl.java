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
import java.util.List;

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

     class LessonMapper implements RowMapper<Lesson>  {
        public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
            Lesson lesson = new Lesson();
            lesson.setId(rs.getLong("lesson_id"));
            lesson.setName(rs.getString("name"));
            lesson.setDescription(rs.getString("description"));
            return lesson;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lesson find(Long lessonId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", lessonId);
            /*RowMapper<Lesson> mapper = (rs, rowNum) -> {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("lesson_id"));
                lesson.setName(rs.getString("name"));
                lesson.setDescription(rs.getString("description"));
                return lesson;
            };*/
            return namedParameterJdbcTemplate.queryForObject(getSqlCommand("LESSON.ID.SELECT"), source, new LessonMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting Lesson for [id:%s]",
                    lessonId), ex);
        }
    }

    @Override
    public List<Lesson> get(Long profileId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", profileId);
            /*RowMapper<Lesson> mapper = (rs, rowNum) -> {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("lesson_id"));
                lesson.setName(rs.getString("name"));
                lesson.setDescription(rs.getString("description"));
                return lesson;
            };*/
            return namedParameterJdbcTemplate.query(getSqlCommand("LESSON.PROFILE_ID.SELECT"), source, new LessonMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting the list of Lesson for profile [id:%s]",
                    profileId), ex);
        }
    }

    @Override
    public int save(Lesson lesson) {//todo: how to return the id of the inserted lesson
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", lesson);

            return namedParameterJdbcTemplate.update(getSqlCommand("LESSON.INSERT"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during inserting a Lesson",
                    lesson), ex);
        }
    }

    @Override
    public int update(Lesson lesson) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", lesson);

            return namedParameterJdbcTemplate.update(getSqlCommand("LESSON.UPDATE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during updating a Lesson [id:%s]",
                    lesson.getId()), ex);
        }
    }

    @Override
    public int delete(Long lessonId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", lessonId);

            return namedParameterJdbcTemplate.update(getSqlCommand("LESSON.DELETE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during deleting a Lesson for [id:%s]",
                    lessonId), ex);
        }

    }
}
