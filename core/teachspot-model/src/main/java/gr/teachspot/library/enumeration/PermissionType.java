package gr.teachspot.library.enumeration;

/** The enumeration PermissionType contains values that indicate the {@link gr.teachspot.library.domain.Profile profile's} permissions types. */
public enum PermissionType {
    /** This permission indicates that the user is eligible to register a {@link gr.teachspot.library.domain.User teacher}. */
    REGISTER_TEACHER,
	/** This permission indicates that the user is eligible to create a {@link gr.teachspot.library.domain.Lesson lesson's}. */
	CREATE_LESSON,
	/** This permission indicates that the user is eligible to read a {@link gr.teachspot.library.domain.Lesson lesson}. */
	READ_LESSON,
    /** This permission indicates that the user is eligible to edit a {@link gr.teachspot.library.domain.Lesson lesson}. */
    UPDATE_LESSON;

}
