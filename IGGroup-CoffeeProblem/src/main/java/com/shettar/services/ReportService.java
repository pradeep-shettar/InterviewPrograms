/**
 * 
 */
package com.shettar.services;

import java.util.Date;

import com.shettar.entities.ReportForTheDay;

/**
 * @author Pradeep.Shettar
 *
 *	Service class for handling reports for Coffee stall.
 */
public interface ReportService {

	/**
	 * The method to get the report of coffee sold for the day.
	 * 
	 * @param reportDate
	 * @return 
	 */
	ReportForTheDay getReport(Date reportDate);
}
