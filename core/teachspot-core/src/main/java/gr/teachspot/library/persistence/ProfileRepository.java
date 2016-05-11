package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Profile;

/** The interface Profile repository contains all {@link Profile} related database actions. */
public interface ProfileRepository {

    /**
     * Return the {@link Profile} for the provided id.
     *
     * @param profileId The id of the {@link Profile} to search with
     * @return The {@link Profile}
     */
    Profile find(Long profileId);

}
