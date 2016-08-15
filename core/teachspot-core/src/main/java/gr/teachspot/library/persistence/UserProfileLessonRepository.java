package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.UserProfileLesson;
import gr.teachspot.library.exception.DataException;

import java.util.Date;

/** The interface UserProfileLesson repository contains all {@link UserProfileLesson} related database actions. */
public interface UserProfileLessonRepository {

    /**
     * Inserts a {@link UserProfileLesson} .
     * @param userProfileLesson the {@link UserProfileLesson}  to insert
     * @return the id of the {@link UserProfileLesson} that was inserted
     *
     * @throws DataException if an error occurs in the database
     */
    Long save(UserProfileLesson userProfileLesson) throws DataException ;

    /**
     * Updates the given {@link UserProfileLesson}.
     *
     * @param profileId The {@link String profileId} for which we want to add the token.
     * @param lessonId The {@link String lessonId} for which we want to add the token.
     * @param token The {@link String token} to be stored in the database.
     *
     * @throws DataException if an error occurs in the database
     */
    void update(Long profileId, Long lessonId, String token, Date tokenDate) throws DataException;

    /**
     * Find a {@link UserProfileLesson} record for the given token.
     *
     * @param token The {@link String token} with which we want to search in the database.
     *
     * @return the {@link UserProfileLesson} that was retrived
     *
     * @throws DataException if an error occurs in the database
     */
    UserProfileLesson find(String token) throws DataException;
}