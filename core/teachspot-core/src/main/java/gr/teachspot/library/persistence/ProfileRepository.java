package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Profile;
import gr.teachspot.library.domain.User;
import java.util.List;

/** The interface Profile repository contains all {@link Profile} related database actions. */
public interface ProfileRepository {

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

}
