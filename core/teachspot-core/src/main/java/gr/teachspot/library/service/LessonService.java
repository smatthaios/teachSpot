package gr.teachspot.library.service;

import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.domain.Profile;

import java.util.List;

/** The interface Lesson service contains all the business methods related to a {@link gr.teachspot.library.domain.Lesson}. */
public interface LessonService {

    /**
     * Returns the {@link Lesson} for the provided id.
     *
     * @param lessonId The id of the {@link Lesson} to search with
     * @return The {@link Lesson}
     */
    Lesson find(Long lessonId);

    /**
     * Returns a list of {@link Lesson} of the provided profile id.
     *
     * @param profileId The id of the {@link Profile} to search with
     * @return The list of {@link Lesson}
     */
    List<Lesson> get(Long profileId);

    /**
     * Inserts or updates a {@link Lesson} .
     * @param lesson The {@link Lesson} to insert/update
     */
    void saveOrUpdate(Lesson lesson);

    /**
     * Deletes the {@link Lesson} for the provided list of lesson ids.
     * @param lessonList The list with the ids of the {@link Lesson} to delete
     */
    void delete(List<Long> lessonList);

}
