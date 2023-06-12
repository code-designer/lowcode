package org.lowcode.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * This provides a set of simple and useful functions for LocalDate
 * @author bigoh
 *
 */
public class DateUtils {
	
	/**
	 * Convert a String into LocalDate
	 * @param date is a string
	 * @param pattern is a string that describe date format
	 * @return LocalDate
	 */
	public static LocalDate toLocalDate (String date, String pattern) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(date, format);
	}
	
	/**
	 * Convert a String into LocalDate
	 * @param date is is a string
	 * @param pattern is a string that describe date format
	 * @param locale is specific geographical region
	 * @return LocalDate
	 */
	public static LocalDate toLocalDate (String date, String pattern, Locale locale) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern, locale);
		return LocalDate.parse(date, format);
	}
	
	/**
	 * Return the remaining days between a date and current date. The first date parameter is the latest.
	 * if reversed, the method will return null
	 * @param date is a LocalDate
	 * @return Period
	 */
	public static Period daysLeft(LocalDate date) {
		LocalDate current = LocalDate.now();
		return daysLeft(date, current);
	}
	
	/**
	 * Return the remaining days between two dates. The first date parameter is the oldest.
	 * if reversed, the method will return null
	 * @param begin is the earliest date
	 * @param end is the most recent date
	 * @return LocalDate
	 */
	public static Period daysLeft(LocalDate begin, LocalDate end) {
		Period period;
		
		if (end.isBefore(begin))
			return null;
		
		period = begin.until(end);
		
		return  period;
		
	}
	
	/**
	 * Format period to String for a better readabiliy
	 * @param period
	 * @return String
	 */
	public static String formatPeriod(Period period) {
		if (period == null)
			return "";
		
		return  (period.getYears() > 0 ? period.getYears() + (period.getYears() > 1 ? " ans " : " an ")  : "") + 
				(period.getMonths() > 0 ? period.getMonths() + " mois " : "") + 
				period.getDays() + (period.getDays() > 1 ? " jours " : " jour ");
	}
	
}
