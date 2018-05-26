/**
 * 
 */
package com.shettar.servicesImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.ReportForTheDay;
import com.shettar.exceptions.DaoException;
import com.shettar.exceptions.ServiceException;
import com.shettar.helpers.ReportServiceHelper;
import com.shettar.services.ReportService;

/**
 * @author Pradeep.Shettar
 *
 *         The implementation class for the report service.
 */
public class ReportServiceImpl implements ReportService {

	/**
	 * Logger for class level logging.
	 */
	Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);

	/**
	 * CoffeeDao for database transaction for Coffee for the day.
	 */
	@Autowired
	CoffeeDao coffeeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.services.ReportService#getReport(java.util.Date)
	 */
	@Override
	public ReportForTheDay getReport(Date reportDate) {
		LOGGER.debug("Entered getReport method with reportDate:" + reportDate);
		ReportForTheDay reportForTheDay = new ReportForTheDay();
		List<CoffeeForTheDay> allCoffeeForTheDay = null;
		try {
			allCoffeeForTheDay = coffeeDao.getAllCoffeeForTheDay(reportDate);
		} catch (DaoException daoException) {
			LOGGER.debug("DaoException caught" + daoException);
			if (CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE.equals(daoException.getMessage())) {
				reportForTheDay = ReportServiceHelper.handleReportError(daoException.getMessage(),
						CoffeeStallConstants.COFFEE_NOT_AVAILABLE_MESSAGE);
			}
		}
		LOGGER.debug("Exiting getReport method allCoffeeForTheDay:" + allCoffeeForTheDay.toString());
		return reportForTheDay;
	}

}
