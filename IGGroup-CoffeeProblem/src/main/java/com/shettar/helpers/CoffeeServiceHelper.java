/**
 * 
 */
package com.shettar.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.exceptions.ServiceException;

/**
 * @author Pradeep.Shettar
 * 
 *         The helper class for CoffeeService.
 */
public class CoffeeServiceHelper {

	/**
	 * Logger for class level logging.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(CoffeeServiceHelper.class);

	/**
	 * Default constructor
	 */
	public CoffeeServiceHelper() {
	}

	/**
	 * The method for handling exceptions caught at service layer.
	 * 
	 * @param exceptionMessage
	 * @param coffeeForTheDay
	 * @return
	 */
	public static CoffeeResponse constructCoffeeResponseForException(String exceptionMessage,
			CoffeeForTheDay coffeeForTheDay) {
		LOGGER.debug(
				"Entered the constructCoffeeResponseForException method of CoffeeServiceHelper class with exception: "
						+ exceptionMessage);
		CoffeeResponse coffeeResponse = new CoffeeResponse();
		if (exceptionMessage != null
				&& CoffeeStallConstants.CREATING_DUPLICATE_COFFEE_ENTRY_CODE.equals(exceptionMessage)) {
			coffeeResponse.setStatusCode(CoffeeStallConstants.PRECONDITION_FAILURE_STATUS_CODE);
			coffeeResponse.setStatusMessage(CoffeeStallConstants.PRECONDITION_FAILURE_MESSAGE);
		}
		LOGGER.debug(
				"Exiting the constructCoffeeResponseForException method of CoffeeServiceHelper class with response: "
						+ coffeeResponse.toString());
		return coffeeResponse;
	}

}
