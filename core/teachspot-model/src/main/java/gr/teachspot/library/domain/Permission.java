package gr.teachspot.library.domain;

import gr.teachspot.library.enumeration.PermissionType;

/** The enumeration Permission contains values that indicate the {@link gr.teachspot.library.domain.Profile profile's} permissions. */
public class Permission {
    private Long id;
    private PermissionType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PermissionType getType() {
        return type;
    }

    public void setType(PermissionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
