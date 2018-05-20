/**
 * 
 */
package com.shettar.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.CoffeeResponse;
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
	 * @param serviceException
	 * @return
	 */
	public static CoffeeResponse constructCoffeeResponseForException(ServiceException serviceException) {
		LOGGER.debug(
				"Entered the constructCoffeeResponseForException method of CoffeeServiceHelper class with exception: "
						+ serviceException.toString());
		CoffeeResponse coffeeResponse = new CoffeeResponse();
		if (serviceException.getMessage() != null
				&& CoffeeStallConstants.CREATING_DUPLICATE_COFFEE_ENTRY_CODE.equals(serviceException.getMessage())) {
			coffeeResponse.setStatusCode(CoffeeStallConstants.PRECONDITION_FAILURE_STATUS_CODE);
			coffeeResponse.setStatusMessage(CoffeeStallConstants.PRECONDITION_FAILURE_MESSAGE);
		}
		LOGGER.debug(
				"Exiting the constructCoffeeResponseForException method of CoffeeServiceHelper class with response: "
						+ coffeeResponse.toString());
		return coffeeResponse;
	}

}
