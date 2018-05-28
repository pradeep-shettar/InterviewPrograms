/**
 * 
 */
package com.shettar.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.ReportForTheDay;
import com.shettar.helpers.DateUtil;
import com.shettar.services.ReportService;

/**
 * @author Pradeep.Shettar
 * 
 *         The controller class to generate reports for the coffee.
 *
 */
@RestController
@RequestMapping("/reports")
public class ReportController {

	/**
	 * The logger for class level logging.
	 */
	private Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

	/**
	 * Service class object for reports service.
	 */
	@Autowired
	ReportService reportService;

	@RequestMapping(method = RequestMethod.GET, params = {
			CoffeeStallConstants.DATE_PARAM }, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ReportForTheDay getReportForTheDay(
			@RequestParam(CoffeeStallConstants.DATE_PARAM) String reportDate) {
		LOGGER.debug("Entered getReportForTheDay method with date: " + reportDate);
		Date dateValue = DateUtil.constructDate(reportDate, "dd-MM-yyyy");
		ReportForTheDay reportForTheDay = reportService.getReport(dateValue);
		LOGGER.debug("Exiting getReportForTheDay method reportForTheDay: " + reportForTheDay.toString());
		return reportForTheDay;
	}

}
