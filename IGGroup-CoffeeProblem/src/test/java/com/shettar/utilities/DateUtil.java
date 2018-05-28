/**
 * 
 */
package com.shettar.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Pradeep.Shettar
 * 
 *         Utility class for Date time.
 *
 */
public class DateUtil {

	/**
	 * @param string
	 * @return
	 */
	public static Date constructDate(String dateTimeParam, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateTimeParam);
		} catch (ParseException parseException) {
			parseException.printStackTrace();
		}
		return date;
	}

	/**
	 * @param servingDate
	 * @param reportDate
	 * @return
	 */
	public static boolean isSameDay(Date servingDate, Date reportDate) {
		Calendar servingCalendar = Calendar.getInstance();
		servingCalendar.setTime(servingDate);

		Calendar reportCalendar = Calendar.getInstance();
		reportCalendar.setTime(reportDate);
		return (servingCalendar.get(Calendar.DAY_OF_MONTH) == reportCalendar.get(Calendar.DAY_OF_MONTH)
				&& servingCalendar.get(Calendar.MONTH) == reportCalendar.get(Calendar.MONTH)
				&& servingCalendar.get(Calendar.YEAR) == reportCalendar.get(Calendar.YEAR));
	}

}
