package gr.teachspot.library.enumeration;

/**
 * The Subject enumerator
 */
public enum Subject {
    PHYSICS(1),
    MATHEMATICS(2),
    GREEK(3),
    ANCIENT_GREEK(4),
    BIOLOGY(5),
    CHEMISTRY(6),
    DEFAULT(7);

    private final int code;

    Subject(int code) {
        this.code = code;
    }
}