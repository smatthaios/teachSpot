package gr.teachspot.library.utils;

import gr.teachspot.library.enumeration.DateFormat;
import gr.teachspot.library.enumeration.SupportedLanguage;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Interval;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** This class holds constant object instances in order to be used throughout the project. */
public final class DateUtils {

    /** --------------------------------------    Date Parsing Utils  --------------------------------------------------- */
    /** The Constant FULL_DATE_FORMAT. It is used in order to format {@link Date} objects using up to second precision. */
    private static final ThreadLocal<SimpleDateFormat> FULL_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormat.DATE_TO_SEC_PRECISION.getFormat(), SupportedLanguage.getDefault().getLocale());
        }
    };

    /**
     * The Constant FULL_DATE_FORMAT. It is used in order to format {@link Date} objects using up to second precision with reverse input of
     * years and months in comparison with the simple one.
     */
    private static final ThreadLocal<SimpleDateFormat> FULL_DATE_FORMAT_REVERSE = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormat.DATE_TO_SEC_PRECISION_REVERSE.getFormat(), SupportedLanguage.getDefault().getLocale());
        }
    };

    /** The Constant BASIC_DATE_FORMAT. It is used in order to format {@link Date} objects using up to day precision. */
    private static final ThreadLocal<SimpleDateFormat> BASIC_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormat.DATE_PRECISION.getFormat(), SupportedLanguage.getDefault().getLocale());
        }
    };

    /** The Constant US_DATE_FORMAT. It is used in order to format {@link Date} objects using US related date format. */
    private static final ThreadLocal<SimpleDateFormat> US_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormat.US_DATE.getFormat(), SupportedLanguage.getDefault().getLocale());
        }
    };

    /** The Constant BUS_DATE_FORMAT. It is used in order to format {@link Date} objects using BUS related date format. */
    private static final ThreadLocal<SimpleDateFormat> UI_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormat.DATE_UI_PRECISION.getFormat(), SupportedLanguage.getDefault().getLocale());
        }
    };

    /** The private constructor used to defeat warning about singleton and abstract classes. */
    private DateUtils() {
    }

    /**
     * Gets the date using up to second precision.
     *
     * @param date the date to format
     * @return the string representation
     */
    public static String getDateInDashFullFormat(final Date date) {
        return UI_DATE_FORMAT.get().format(date);
    }

    /**
     * Gets the date using up to second precision.
     *
     * @param date the date to format
     * @return the string representation
     */
    public static String getDateInFullFormat(final Date date) {
        return FULL_DATE_FORMAT.get().format(date);
    }

    /**
     * Gets the date using US format.
     *
     * @param date the date to format
     * @return the string representation
     */
    public static String getUSFormat(final Date date) {
        return US_DATE_FORMAT.get().format(date);
    }

    /**
     * Gets the date using up to day precision..
     *
     * @param date the date to format
     * @return the string representation
     */
    public static String getDateInBasicFormat(final Date date) {
        return BASIC_DATE_FORMAT.get().format(date);
    }

    /**
     * Parses the date from basic format string.
     *
     * @param dateToken the date string
     * @return the date from basic string format
     * @throws ParseException the exception raised when date token is incompatible
     */
    public static Date parseDateFromBasicFormatString(final String dateToken) throws ParseException {
        return BASIC_DATE_FORMAT.get().parse(dateToken);
    }

    public static Date parseDateFromUIFormatString(final String dateToken) throws ParseException {
        return UI_DATE_FORMAT.get().parse(dateToken);
    }

    /**
     * Parses the date from reverse full format string.
     *
     * @param dateToken the date string
     * @return the date from basic string format
     * @throws ParseException the exception raised when date token is incompatible
     */
    public static Date parseDateFromFullFormatString(final String dateToken) throws ParseException {
        return FULL_DATE_FORMAT_REVERSE.get().parse(dateToken);
    }

    /**
     * Parses the date from US format string.
     *
     * @param dateToken the date string
     * @return the date from US string format
     * @throws ParseException the exception raised when date token is incompatible
     */
    public static Date parseDateFromFullUSFormatString(final String dateToken) throws ParseException {
        return FULL_DATE_FORMAT_REVERSE.get().parse(dateToken);
    }

	/**
	 * Transforms IRI week to {@link Calendar}.
	 *
	 * @param iriWeek the excel date to transform
	 * @return the representation of the given IRI week
	 */
	public static Calendar transformIriWeekToDate(final int iriWeek) {
		DateTime timeFrom = new DateTime(1900, 1, 1, 0, 0).plusDays(29100).plusWeeks(iriWeek);
		if (timeFrom.getDayOfWeek() != DateTimeConstants.SUNDAY) {
			timeFrom = timeFrom.withDayOfWeek(DateTimeConstants.MONDAY).minusDays(1);
		}
		return timeFrom.toGregorianCalendar();
	}

	/**
	 * Checks if a specific {@link Date} object refers to the given date of the week.
	 *
	 * @param date specific {@link Date} object
	 * @param dayOfWeek the date of the week as an integer value (SUNDAY = 1, MONDAY = 2, ... , SATURDAY = 7)
	 * @return a boolean value representing if the specific {@link Date} object refers to the given date of the week.
	 */
	public static boolean checkDateOfWeek(final Date date, int dayOfWeek) {
		if(dayOfWeek < 1 || dayOfWeek > 7)
			return false;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int weekDate = c.get(Calendar.DAY_OF_WEEK);

		if(weekDate != dayOfWeek)
			return false;
		else
			return true;
	}

	/**
	 * Transform the given date to IRI week date. This method returns the start of the corresponding week.
	 *
	 * @param date the date to transform
	 * @return the date transform to IRI week
	 */
	public static int transformDateToIriWeek(final Date date) {
		DateTime startDate = new DateTime(1900, 1, 1, 0, 0);

		DateTime now = new DateTime(date);
		if (now.getDayOfWeek() != DateTimeConstants.SUNDAY) {
			now = now.withDayOfWeek(DateTimeConstants.MONDAY).minusDays(1);
		}

		return new Interval(startDate, now).toDuration().toStandardDays().minus(29095).dividedBy(7).getValue(0);
	}

}
