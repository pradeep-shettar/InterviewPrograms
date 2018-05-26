/**
 * 
 */
package com.shettar.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.ReportForTheDay;

/**
 * @author Pradeep.Shettar
 * 
 * Helper class for Report service.
 *
 */
public class ReportServiceHelper {
	
	/**
	 * Logger for class level logging.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(ReportServiceHelper.class);

	/**
	 * @param string 
	 * @return 
	 * 
	 */
	public static ReportForTheDay handleReportError(String errorCode, String message) {
		LOGGER.debug("Entered handleReportError method");
		ReportForTheDay reportForTheDay = new ReportForTheDay();
		reportForTheDay.setStatusCode(errorCode);
		reportForTheDay.setStatusMessage(message);
		LOGGER.debug("Exiting handleReportError method");
		return reportForTheDay;
	}

}
