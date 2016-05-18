package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Permission;
import gr.teachspot.library.domain.Profile;

import java.util.List;


/** The interface Permission repository contains all {@link Permission} related database actions. */
public interface PermissionRepository {

    /**
     * Return the {@link Permission} for the provided id.
     *
     * @param permissionId The id of the {@link Permission} to search with
     * @return The {@link Permission}
     */
    Permission find(Long permissionId);

    /**
     * Returns the list of {@link Permission} of the provided profile id.
     *
     * @param profileId The id of the {@link Profile} to search with
     * @return The list of {@link Permission}
     */
    List<Permission> get(Long profileId);

    /**
     * Deletes the {@link Permission} for the provided permission id.
     * @param permissionId The id of the {@link Permission} to delete
     * @return the number of rows affected
     */
    int delete(Long permissionId);



}
