package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Lesson;


/** The interface Lesson repository contains all {@link Lesson} related database actions. */
public interface LessonRepository {

    /**
     * Return the {@link Lesson} for the provided id.
     *
     * @param lessonId The id of the {@link Lesson} to search with
     * @return The {@link Lesson}
     */
    Lesson find(Long lessonId);
}
