package gr.teachspot.library.domain;

import gr.teachspot.library.enumeration.PermissionType;

/** The enumeration Profile contains values that indicate the {@link gr.teachspot.library.domain.Profile profile's} permissions. */
public class Permission {
    private PermissionType type;

    public PermissionType getType() {
        return type;
    }

    public void setType(PermissionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "type=" + type +
                '}';
    }
}
