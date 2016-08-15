package gr.teachspot.library.service;

import gr.teachspot.library.domain.Profile;
import gr.teachspot.library.domain.User;

import java.util.List;

/** The interface Profile service contains all the business methods related to a {@link gr.teachspot.library.domain.Profile}. */
public interface ProfileService {

    /**
     * Return the {@link Profile} for the provided id.
     *
     * @param profileId The id of the {@link Profile} to search with
     * @return The {@link Profile}
     */
    Profile find(Long profileId);

    /**
     * Return a {@link List} of {@link Profile} for the provided user id.
     *
     * @param userId The id of the {@link User} to search with
     * @return  A {@link List} of {@link User}
     */
    List<Profile> get(Long userId);

    /**
     * Inserts a {@link Profile} .
     * @param profile the {@link Profile}  to insert
     * @return the id of the {@link Profile} that was inserted
     */
    Long save(Profile profile);

    /**
     * Updates a {@link Profile} .
     * @param profile the {@link Profile}  to insert
     * @return the number of rows affected
     */
    int update(Profile profile);

    /**
     * Deletes the {@link Profile profile} for the provided profile id.
     * @param profileId The id of the {@link Profile} to delete
     * @return the number of rows affected
     */
    int delete(Long profileId);

    /**
     * Sends a pair request for the {@link gr.teachspot.library.domain.Lesson lesson} to the {@link User user}.
     *
     * @param profileId The {@link User user's} {@link Profile} id of the {@link User user} that owns the lesson
     * @param lessonId The {@link gr.teachspot.library.domain.Lesson} id of the {@link gr.teachspot.library.domain.Lesson lesson} to pair with
     * @param profileId The {@link Profile} id of the {@link User user} we want to pair with
     *
     * @throws gr.teachspot.library.exception.UserNotFoundException If the {@link User user} wasn't found
     * @throws gr.teachspot.library.exception.LessonNotFoundException If the {@link gr.teachspot.library.domain.Lesson lesson} wasn't found
     */
    void pairRequest(Long activeProfileId, Long lessonId, Long profileId);

    /**
     * Sends a pair request for the {@link gr.teachspot.library.domain.Lesson lesson} to the {@link User user}.
     *
     * @param profileId The {@link User user's} {@link Profile} id of the {@link User user} that will be paired with the lesson
     * @param token The token that will used to find the pair request
     */
    void pairAccept(Long profileId, String token);

}
