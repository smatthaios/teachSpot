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

    private final int code;

    SchoolLevel(int code) {
        this.code = code;
    }
}
