package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.UserProfileLesson;
import gr.teachspot.library.exception.DataException;

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
}