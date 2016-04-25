package gr.teachspot.library.enumeration;

/**
 * This is used in order to define the currency value that it will be used in the application.
 */
public enum Locale {
    UK("UK", "United Kingdom", "&pound;");

    /** The locales name. */
    private String name;

    /** The country. */
    private String country;

    /** The html Currency Symbol. */
    private String currencySymbol;

    Locale(String name, String country, String currencySymbol) {
        this.name = name;
        this.country = country;
        this.currencySymbol = currencySymbol;
    }

    /**
     * Gets the locales name.
     *
     * @return the locales name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the html locales currency symbol.
     *
     * @return the html locales currency symbol
     */
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * Returns the {@link Locale} object that corresponds to the given locales name
     *
     * @param name the {@link String} locales name
     * @return the {@link Locale} object
     */
    public static Locale get(final String name) {
        for (final Locale e : Locale.values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return getDefault();
    }


    /**
     * Gets the default locale which in our case is UK.
     *
     * @return the default currency
     */
    public static Locale getDefault() {
        return Locale.UK;
    }
}
