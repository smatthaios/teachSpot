package gr.teachspot.library.service;

import gr.teachspot.library.domain.Permission;
import gr.teachspot.library.domain.Profile;

import java.util.List;

/** The interface Permission service contains all the business methods related to a {@link gr.teachspot.library.domain.Permission}. */
public interface PermissionService {

    /**
     * Returns the {@link Permission} for the provided id.
     *
     * @param permissionId The id of the {@link Permission} to search with
     * @return The {@link Permission}
     */
    Permission find(Long permissionId);

    /**
     * Returns a list of {@link Permission} of the provided profile id.
     *
     * @param profileId The id of the {@link Profile} to search with
     * @return The list of {@link Permission}
     */
    List<Permission> get(Long profileId);

    /**
     * Deletes the {@link Permission} for the provided list of Permission ids.
     * @param permissionList The list with the ids of the {@link Permission} to delete
     */
    void delete(List<Long> permissionList);

}
