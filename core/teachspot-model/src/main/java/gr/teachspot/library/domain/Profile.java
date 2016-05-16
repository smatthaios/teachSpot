package gr.teachspot.library.domain;

import gr.teachspot.library.enumeration.ProfileType;

import java.util.List;

/** The enumeration Profile contains values that indicate the {@link User user's| role. */
public class Profile {

	private long id;
	private ProfileType type;
    private List<Permission> permissionList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

	public ProfileType getType() {
		return type;
	}

	public void setType(ProfileType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Profile{" +
				"type=" + type +
				", permissionList=" + permissionList +
				'}';
	}
}
