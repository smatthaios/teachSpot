package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Permission;


/** The interface Permission repository contains all {@link Permission} related database actions. */
public interface PermissionRepository {

    /**
     * Return the {@link Permission} for the provided id.
     *
     * @param permissionId The id of the {@link Permission} to search with
     * @return The {@link Permission}
     */
    Permission find(Long permissionId);



}
