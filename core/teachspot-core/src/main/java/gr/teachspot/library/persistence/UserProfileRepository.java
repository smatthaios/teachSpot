package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.dto.UserProfile;
import gr.teachspot.library.exception.DataException;

import java.util.List;


/**
 * The interface User Profile repository contains all methods needed to retrieve the relations between {@link gr.teachspot.library.domain.Profile profiles} and  {@link gr.teachspot.library.domain.User users}.
 */
public interface UserProfileRepository {

    /**
     * Returns the {@link java.util.List} of {@link gr.teachspot.library.domain.dto.UserProfile} pairs for the provided {@link gr.teachspot.library.domain.User user} id.
     *
     * @param userId The id of the {@link gr.teachspot.library.domain.User user} to search with
     * @return A {@link java.util.List} of the {@link gr.teachspot.library.domain.dto.UserProfile}
     *
     * @throws DataException if an error occurs in the database.
     */
    List<UserProfile> get(Long userId) throws DataException;

    /**
     * Finds the {@link gr.teachspot.library.domain.User user} who owns the provided {@link gr.teachspot.library.domain.Profile profile} given the {@link gr.teachspot.library.domain.Profile profiles} id.
     *
     * @param profileId the id of the {@link gr.teachspot.library.domain.Profile profile} to search with.
     * @return The the {@link gr.teachspot.library.domain.dto.UserProfile} that contains the id of the {@link gr.teachspot.library.domain.User} who owns the provided {@link gr.teachspot.library.domain.Profile profile}.
     *
     * @throws DataException if an error occurs in the database.
     */
    UserProfile find(Long profileId) throws DataException;

    /**
     * Save a new relation between a {@link gr.teachspot.library.domain.User user} and a {@link gr.teachspot.library.domain.Profile profile}.
     *
     * @param profileId the {@link gr.teachspot.library.domain.Profile profile} id
     * @param userId    the {@link gr.teachspot.library.domain.User user} id
     *
     * @throws DataException if an error occurs in the database.
     */
    void save(Long profileId, Long userId) throws DataException;

    /**
     * Deletes all records that belong to the provided {@link gr.teachspot.library.domain.User user}.
     *
     * @param userId The id of the {@link gr.teachspot.library.domain.User user}.
     * @return The number of rows that were deleted.
     *
     * @throws DataException if an error occurs in the database.
     */
    int deleteByUser(Long userId) throws DataException;

    /**
     * Deletes all records that belong to the provided {@link gr.teachspot.library.domain.Profile profile}.
     *
     * @param profileId The id of the {@link gr.teachspot.library.domain.Profile profile}.
     * @return The number of rows that were deleted.
     *
     * @throws DataException if an error occurs in the database.
     */
    int deleteByProfile(Long profileId) throws DataException;
}
