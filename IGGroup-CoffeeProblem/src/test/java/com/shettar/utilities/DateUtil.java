/**
 * 
 */
package com.shettar.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Pradeep.Shettar
 * 
 * Utility class for Date time.
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

}
