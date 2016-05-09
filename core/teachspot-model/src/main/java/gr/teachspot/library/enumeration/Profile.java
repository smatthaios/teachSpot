package gr.teachspot.library.enumeration;

import java.util.List;

/** The enumeration Profile contains values that indicate the {@link gr.teachspot.library.domain.User user's| role. */
public enum Profile {

	/** This role indicates that the user is a Student. */
	STUDENT,
	/** This role indicates that the user is an account administrator. This user can create users and has an overall account supervision. */
    ADMINISTRATOR,
	/** This role indicates that the user is a preparatory school. */
	SCHOOL,
	/** This role indicates that the user is a teacher that has private lessons. */
	PRIVATE_TEACHER,
	/** This role indicates that the user is a teacher working for a school. */
	SCHOOL_TEACHER;

    private List<Permission> permissionList;

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
