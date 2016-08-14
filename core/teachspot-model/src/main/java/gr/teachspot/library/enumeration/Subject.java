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

    private int code;

    Subject(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Subject get(final int code) {
        for (final Subject subject : Subject.values()) {
            if (subject.getCode() == code) {
                return subject;
            }
        }
        return DEFAULT;
    }
}