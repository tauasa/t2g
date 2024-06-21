package org.tauasa.t2g.util;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class Utils {

	public static final String TEE_TIME_FORMAT = "yyMMddHHmm";
	public static final String LENIENT_DATE_PARSING_KEY = "t2g.lenient.date.parsing";
	public static final String UTF8 = "UTF-8";
	public static final byte[] NEWLINE = "\r\n".getBytes();
	//formatter cache
	private static final Map<String, DateFormat> FORMATTERS = new HashMap<>();

    /**
	 * Creates a {@link DateFormat} for the specified pattern. By default the
	 * {@link DateFormat} has lenient parsing enabled but can be overridden
	 * by setting the system property <code>t2g.lenient.date.parsing</code> to false.
	 * */
	public static final DateFormat createDateFormat(final String pattern){
		return createDateFormat(pattern, TimeZone.getDefault(), isLenientDateParsing());
	}

    public static final DateFormat createDateFormat(String pattern, TimeZone tz, boolean lenient){
		DateFormat df = FORMATTERS.get(pattern);
		if(df==null){
			df = new SimpleDateFormat(pattern);
			df.setLenient(lenient);
			if(tz!=null){
				df.setTimeZone(tz);
			}
			FORMATTERS.put(pattern, df);
		}
		return df;
	}

    private static boolean isLenientDateParsing(){
		return Boolean.parseBoolean(System.getProperty(LENIENT_DATE_PARSING_KEY, "true"));
	}

    /**
	 * Returns true if the first {@link Date} is after the second {@link Date} according to the {@link Date#after(Date)} method.
	 * If {@code compareTime} is false then times for both dates are zero'd out before the comparison
	 * */
	public static boolean isAfter(Date d1, Date d2, boolean compareTime){
		if(d1==null || d2==null){
			throw new NullPointerException("One of the dates being compared is null");
		}
		if(!compareTime){
			return setTime(d1, 0, 0, 0).after(setTime(d2, 0, 0, 0));
		}
		return d1.after(d2);
	}

	public static boolean isOnOrAfter(Date d1, Date d2, boolean compareTime){
		if(d1==null || d2==null){
			throw new NullPointerException("One of the dates being compared is null");
		}
		if(!compareTime){
			Date _d1 = setTime(d1, 0, 0, 0);
			Date _d2 = setTime(d2, 0, 0, 0);
			return _d1.equals(_d2) || _d1.after(_d2);
		}
		return d1.equals(d2) || d1.after(d2);
	}

	public static boolean isBefore(Date d1, Date d2, boolean compareTime){
		if(d1==null || d2==null){
			throw new NullPointerException("One of the dates being compared is null");
		}
		if(!compareTime){
			return setTime(d1, 0, 0, 0).before(setTime(d2, 0, 0, 0));
		}
		return d1.before(d2);
	}

	public static boolean isOnOrBefore(Date d1, Date d2, boolean compareTime){
		if(d1==null || d2==null){
			throw new NullPointerException("One of the dates being compared is null");
		}
		if(!compareTime){
			Date _d1 = setTime(d1, 0, 0, 0);
			Date _d2 = setTime(d2, 0, 0, 0);
			return _d1.equals(_d2) || _d1.before(_d2);
		}
		return d1.equals(d2) || d1.before(d2);
	}

    /**
	 * Adjusts the time for the specified to midnight. If the date is null a new date is created for the
	 * current day and zero'd to midnight
	 * */
	public static Date zero(Date date){
		if(date==null){
			return zero();
		}
		return setTime(date, 0, 0, 0);
	}

	/**
	 * Creates a new date representing midnight for the current day
	 * */
	public static Date zero(){
		return setTime(new Date(), 0, 0, 0);
	}

	/**
	 * Shorthand for {@link Utils#parseDate(String, MMDDYYYY)}
	 * */
	public static Date createTeeTime(String ts)throws ParseException{
		return parseDate(ts, TEE_TIME_FORMAT);
	}

	/**
	 * Formats the specified date
	 * */
	public static final String formatDate(Date d, String pattern){
		if(d==null){
			return null;
		}
		return createDateFormat(pattern).format(d);
	}

	/**
	 * Parses the a date from the specified string using the specified pattern.
	 * Returns null of the specified date string (ts) is null or 0-length
	 * */
	public static final Date parseDate(String ts, String pattern)throws ParseException {
		if (isEmpty(ts)) {
			return null;
		}
		return createDateFormat(pattern).parse(ts);
	}

	/**
	 * Adjusts the specified date the specified number of days (use a negative value to
	 * subtract days)
	 * */
	public static Date adjustDate(Date ts, int numDays){
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		c.add(Calendar.DATE, numDays);
		return c.getTime();
	}

	public static Date adjustToLastDayOfMonth(Date ts){
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
		return c.getTime();
	}

	/**
	 * Sets the time for the specified date (using a 24-hour clock). The milliseconds
	 * field is set to 0
	 * */
	public static Date setTime(Date ts, int hour, int minutes, int seconds){
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minutes);
		c.set(Calendar.SECOND, seconds);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date adjustMonth(Date ts, int numMonths){
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		c.add(Calendar.MONTH, numMonths);
		return c.getTime();
	}

	public static Date setYear(Date ts, int year){
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		c.set(Calendar.YEAR, year);
		return c.getTime();
	}

	/**
	 * Returns the difference in years between the specified dates
	 * */
	public static long getDiffInYears(Date d1, Date d2){
		return getDiffInDays(d1, d2)/365L;
	}

	/**
	 * Returns the difference in seconds between the specified dates
	 */
	public static long getDiffInSeconds(Date d1, Date d2){
		if(d1==null || d2==null){
			throw new RuntimeException("One or more null dates specified");
		}
		return Math.abs(d1.getTime()-d2.getTime())/1000L;
	}

	/**
	 * Returns the difference in minutes between the specified dates
	 * */
	public static long getDiffInMinutes(Date d1, Date d2){
		return getDiffInSeconds(d1, d2)/60L;
	}

	/**
	 * Returns the difference in hours between the specified dates
	 */
	public static long getDiffInHours(Date d1, Date d2){
		return getDiffInMinutes(d1, d2)/60L;
	}

	/**
	 * Returns the difference in days between the specified dates
	 */
	public static long getDiffInDays(Date d1, Date d2){
		return getDiffInHours(d1, d2)/24L;
	}

	/**
	 * Returns true if the specified date falls on a Saturday or Sunday
	 * */
	public static final boolean isWeekendDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_WEEK);
		return day==Calendar.SATURDAY || day==Calendar.SUNDAY;
	}

	public static int getCurrentYear(){
		return getYear(new Date());
	}

	public static int getCurrent2DigitYear(){
		return getYear(new Date());
	}

	public static int getCurrentMonth(){
		return getMonth(new Date());
	}

	public static int getCurrentDayOfMonth(){
		return getDayOfMonth(new Date());
	}

	/**
	 * Returns the year of the specified date as a 2-digit string
	 * */
	public static String getYear2Digit(Date ts){
		return formatDate(ts, "yy");
	}

	/**
	 * Returns the year from the specified date
	 */
	public static int getYear(Date ts){
		if (ts==null) {
			return getYear(new Date());
		}
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		return c.get(Calendar.YEAR);
	}

	public static int getMonth(Date ts){
		if (ts==null) {
			return getMonth(new Date());
		}
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		return c.get(Calendar.MONTH);
	}

	public static int getDayOfMonth(Date ts){
		if (ts==null) {
			return getDayOfMonth(new Date());
		}
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Factory method for creating a {@link Map} initialized with
	 * the specified keys and values
	 * */
	public static <K, V> Map<K, V> createMap(K[] key, V[] value){
		HashMap<K, V> map = new HashMap<>();
		for(int i=0;i<key.length;i++){
			map.put(key[i], value[i]);
		}
		return map;
	}

	/**
	 * Returns true if the specified {@link CharSequence} is null or empty
	 * */
	public static final boolean isEmpty(CharSequence s){
		return s==null || s.length() == 0;
	}

	/**
	 * Returns true if the specified {@link String} is null or has no non-whitespace characters
	 * */
	public static final boolean isEmpty(String s){
		return s==null || s.trim().length() == 0;
	}

	public static String createString(char c, int len){
		StringBuilder b = new StringBuilder();
		for(int i=0;i<len;i++){
			b.append(c);
		}
		return b.toString();
	}

	/**
	 * Returns true if the specified Collection is null or empty
	 * */
	public static final boolean isEmpty(Collection<?> c){
		return (c==null || c.isEmpty());
	}

	/**
	 * Returns true if the specified List is null or empty
	 * */
	public static final boolean isEmpty(List<?> list){
		return (list==null || list.isEmpty());
	}

	/**
	 * Returns true if the specified Map is null or empty
	 * */
	public static final boolean isEmpty(Map<?, ?> map){
		return (map==null || map.isEmpty());
	}

	/**
	 * Returns true if the specified array is null or zero-length
	 * */
	public static final boolean isEmpty(Object[] arr){
		return (arr==null || arr.length == 0);
	}

	/**
	 * De-duplicates the specified array
	 * */
	public static String[] deDupe(String[] dups){

		Arrays.sort(dups);

		int k = 1;

		for (int i = 1; i < dups.length; i++){
			if (! dups[i].equals(dups[i -1])){
				dups[k++] = dups[i];
			}
		}

		String[] unique = new String[k];

		System.arraycopy(dups, 0, unique, 0, k);

		return unique;
	}

	/////////////////////////////////////
	// I/O methods
	/////////////////////////////////////

	/**
	 * Writes the specified objects to an output stream (only UTF-8 bytes are written)
	 * */
	public static final void write(OutputStream out, Object... values)throws IOException{
		for (Object val : values) {
			if(val==null){
				continue;
			}
			out.write(val.toString().getBytes(UTF8));
		}
	}

	/**
	 * Writes the specified objects to an output stream (only UTF-8 bytes are written) and
	 * adds a CRLF to the end
	 * */
	public static final void writeln(OutputStream out, Object... values)throws IOException{
		write(out, values);
		out.write(NEWLINE);
	}

}
