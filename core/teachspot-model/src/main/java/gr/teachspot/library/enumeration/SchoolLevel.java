package gr.teachspot.library.enumeration;

/**
 * The SchoolLevel enumerator
 */
public enum SchoolLevel {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6),
    DEFAULT(7);

    private int code;

    SchoolLevel(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SchoolLevel get(final int code) {
        for (final SchoolLevel schoolLevel : SchoolLevel.values()) {
            if (schoolLevel.getCode() == code) {
                return schoolLevel;
            }
        }
        return DEFAULT;
    }
}
