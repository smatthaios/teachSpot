package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.UserProfileLesson;
import gr.teachspot.library.exception.DataException;
import org.joda.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;

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


    @Override
    public void update(Long profileId, Long lessonId, String token, Date tokenDate) throws DataException {
        try {
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            namedParameters.addValue("profileId", profileId);
            namedParameters.addValue("lessonId", lessonId);
            namedParameters.addValue("token", token);
            namedParameters.addValue("token_date", new java.sql.Timestamp(tokenDate.getTime()));
            namedParameterJdbcTemplate.update(getSqlCommand("USER_PROFILE_LESSON.UPDATE"), namedParameters);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while updating UserProfileLesson for Profile[id:%s] and Lesson[id:%s]",
                    profileId, lessonId), ex);
        }
    }

    /** {@inheritDoc} */
    @Override
    public UserProfileLesson find(String token) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("token", token);
            return namedParameterJdbcTemplate.queryForObject(getSqlCommand("USER_PROFILE_LESSON.SELECT_TOKEN"), source, getUserProfileLessonRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting UserProfileLesson for token [%s]",
                    token), ex);
        }
    }



    private RowMapper<UserProfileLesson> getUserProfileLessonRowMapper() {
        return (rs, rowNum) -> {
            UserProfileLesson userProfileLesson = new UserProfileLesson(rs.getLong("user_profile_id"), rs.getLong("lesson_id"));
            userProfileLesson.setToken(rs.getString("token"));
            userProfileLesson.setTokenDate(rs.getDate("token_date"));
            return userProfileLesson;
        };
    }
}