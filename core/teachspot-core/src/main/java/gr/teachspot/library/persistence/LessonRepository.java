package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.domain.Profile;

import java.util.List;


/** The interface Lesson repository contains all {@link Lesson} related database actions. */
public interface LessonRepository {

    /**
     * Returns the {@link Lesson} for the provided id.
     *
     * @param lessonId The id of the {@link Lesson} to search with
     * @return The {@link Lesson}
     */
    Lesson find(Long lessonId);

    /**
     * Returns the {@link Lesson} of the provided user id.
     *
     * @param profileId The id of the {@link Profile} to search with
     * @return The list of {@link Lesson}
     */
    List<Lesson> get(Long profileId);

    /**
     * Inserts a {@link Lesson} .
     * @param lesson the {@link Lesson}  to insert
     * @return the number of rows affected
     */
    int save(Lesson lesson);

    /**
     * Updates a {@link Lesson} .
     * @param lesson the {@link Lesson}  to insert
     * @return the number of rows affected
     */
    int update(Lesson lesson);

    /**
     * Deletes the {@link Lesson} for the provided lesson id.
     * @param lessonId The id of the {@link Lesson} to delete
     * @return the number of rows affected
     */
    int delete(Long lessonId);

}
