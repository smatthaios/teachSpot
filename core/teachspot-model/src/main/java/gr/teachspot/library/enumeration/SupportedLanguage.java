package gr.teachspot.library.enumeration;

import java.util.Locale;

/** The enumeration {@link SupportedLanguage} represents all supported locales within this system. */
public enum SupportedLanguage {
	/** The english language. */
	ENGLISH("en", Locale.ENGLISH, new Locale("en", "US")),

	/** The french language. */
	FRENCH("fr", new Locale("fr"), new Locale("fr", "FR"));

	/** The locale code. */
	private String code;

	/** The associated {@link java.util.Locale}. */
	private Locale locale;

	/** The regional {@link java.util.Locale} which supports country too. */
	private Locale regionalLocale;

	/**
	 * Instantiates a new {@link SupportedLanguage}.
	 *
	 * @param code           the code
	 * @param locale         the
	 * @param regionalLocale the regional locale
	 */
	private SupportedLanguage(final String code, final Locale locale, final Locale regionalLocale) {
		this.code = code;
		this.locale = locale;
		this.regionalLocale = regionalLocale;
	}

	/**
	 * Gets the code of current {@link SupportedLanguage}.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the {@link java.util.Locale} of current {@link SupportedLanguage}.
	 *
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Gets the regional {@link java.util.Locale}.
	 *
	 * @return the regional
	 */
	public Locale getRegionalLocale() {
		return regionalLocale;
	}

	/**
	 * Gets the {@link SupportedLanguage} from it's code or the default language if the code does not correspond to any
	 * {@link SupportedLanguage}.
	 *
	 * @param code the code
	 * @return the associated language
	 */
	public static SupportedLanguage get(final String code) {
		for (final SupportedLanguage e : SupportedLanguage.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return getDefault();
	}

	/**
	 * Gets the default language which in our case is Greek.
	 *
	 * @return the default language
	 */
	public static SupportedLanguage getDefault() {
		return SupportedLanguage.ENGLISH;
	}
}
