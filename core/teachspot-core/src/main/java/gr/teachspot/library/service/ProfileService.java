package gr.teachspot.library.service;

import gr.teachspot.library.domain.Profile;

/** The interface Profile service contains all the business methods related to a {@link gr.teachspot.library.domain.Profile}. */
public interface ProfileService {

    /**
     * Return the {@link Profile} for the provided id.
     *
     * @param profileId The id of the {@link Profile} to search with
     * @return The {@link Profile}
     */
    Profile find(Long profileId);

}
