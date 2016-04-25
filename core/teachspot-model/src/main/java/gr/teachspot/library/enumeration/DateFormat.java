package gr.teachspot.library.enumeration;

/** The enumeration {@link eu.iri.ace.cbm.enumeration.DateFormat} represents all supported date and time format options. */
public enum DateFormat {
	/** The basic format using day, month and year precision. */
	DATE_PRECISION("dd/MM/yyyy"),

	/** The full format using up to second precision. */
	DATE_TO_SEC_PRECISION("dd/MM/yyyy HH:mm:ss"),

	/** The full format using up to second precision. */
	DATE_TO_SEC_PRECISION_REVERSE("yyyy-MM-dd HH:mm:ss"),

	/** The US based format. */
	US_DATE("yyyy-MM-dd"),

	/** The full format using up to second precision. Slashes removed. */
	DATE_TO_SEC_PRECISION_WITHOUT_SLASH("ddMMyyyy HH:mm:ss");

	/** The date format. */
	private String format;

	/**
	 * Instantiates a new {@link eu.iri.ace.cbm.enumeration.DateFormat}.
	 *
	 * @param format the format
	 */
	private DateFormat(final String format) {
		this.format = format;
	}

	/**
	 * Gets the format of current {@link eu.iri.ace.cbm.enumeration.DateFormat}.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
}
