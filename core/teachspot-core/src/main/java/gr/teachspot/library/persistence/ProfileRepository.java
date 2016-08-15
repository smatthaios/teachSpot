package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Profile;
import gr.teachspot.library.domain.User;
import gr.teachspot.library.enumeration.ProfileType;
import gr.teachspot.library.exception.DataException;

import java.util.List;

/** The interface Profile repository contains all {@link Profile} related database actions. */
public interface ProfileRepository {

    /**
     * Return the {@link Profile} for the provided id.
     *
     * @param profileId The id of the {@link Profile} to search with
     * @return The {@link Profile}
     *
     * @throws DataException if an error occurs in the database
     */
    Profile find(Long profileId) throws DataException;

    /**
     * Return the {@link Profile} for the provided profileType.
     *
     * @param profileType The profileType of the {@link Profile} to search with
     * @return The {@link Profile}
     *
     * @throws DataException if an error occurs in the database
     */
    Profile find(ProfileType profileType) throws DataException;

    /**
     * Return a {@link List} of {@link Profile} for the provided user id.
     *
     * @param userId The id of the {@link User} to search with
     * @return  A {@link List} of {@link User}
     *
     * @throws DataException if an error occurs in the database
     */
    List<Profile> get(Long userId) throws DataException ;

    /**
     * Inserts a {@link Profile} .
     * @param profile the {@link Profile}  to insert
     * @return the id of the {@link Profile} that was inserted
     *
     * @throws DataException if an error occurs in the database
     */
    Long save(Profile profile) throws DataException ;

    /**
     * Updates a {@link Profile} .
     * @param profile the {@link Profile}  to insert
     * @return the number of rows affected
     *
     * @throws DataException if an error occurs in the database
     */
    int update(Profile profile) throws DataException ;

    /**
     * Deletes the {@link Profile profile} for the provided profile id.
     * @param profileId The id of the {@link Profile} to delete
     * @return the number of rows affected
     *
     * @throws DataException if an error occurs in the database
     */
    int delete(Long profileId) throws DataException ;

}
