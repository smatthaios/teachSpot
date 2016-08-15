package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.UserProfileLesson;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * The type UserProfileLesson repository impl contains all {@link UserProfileLesson} related database actions.
 */
@Repository
public class UserProfileLessonRepositoryImpl extends AbstractRepository implements UserProfileLessonRepository {

    /**
     * {@link NamedParameterJdbcTemplate}
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Long save(UserProfileLesson userProfileLesson) throws DataException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("user_profile_id", userProfileLesson.getProfileId());
            source.addValue("lesson_id", userProfileLesson.getLessonId());

            namedParameterJdbcTemplate.update(getSqlCommand("USER_PROFILE_LESSON.INSERT"), source, keyHolder);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while inserting a UserProfileLesson",
                    userProfileLesson.toString()), ex);
        }

        return (Long)keyHolder.getKey();
    }
}