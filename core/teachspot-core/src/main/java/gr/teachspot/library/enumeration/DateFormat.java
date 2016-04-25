package gr.teachspot.library.enumeration;

/** This enumeration represents all supported date and time format options. */
public enum DateFormat {
    /** The basic format using day, month and year precision. */
    DATE_PRECISION("dd/MM/yyyy"),

    /** The basic format using day, month, year precision and dash as separator. */
    DATE_UI_PRECISION("dd-MM-yyyy"),

    /** The full format using up to second precision. */
    DATE_TO_SEC_PRECISION("dd/MM/yyyy HH:mm:ss"),

    /** The full format using up to second precision. */
    DATE_TO_SEC_PRECISION_REVERSE("yyyy-MM-dd HH:mm:ss"),

    /** The US based format. */
    US_DATE("yyyy-MM-dd");

    /** The date format. */
    private String format;

    /**
     * Instantiates a new {@link DateFormat}.
     *
     * @param format the format
     */
    private DateFormat(final String format) {
        this.format = format;
    }

    /**
     * Gets the format of current {@link DateFormat}.
     *
     * @return the format
     */
    public String getFormat() {
        return format;
    }
}
