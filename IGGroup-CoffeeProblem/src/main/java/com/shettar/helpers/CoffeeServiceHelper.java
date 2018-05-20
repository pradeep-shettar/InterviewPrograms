/**
 * 
 */
package com.shettar.helpers;

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
		CoffeeResponse coffeeResponse = new CoffeeResponse();
		if (serviceException.getMessage() != null
				&& CoffeeStallConstants.CREATING_DUPLICATE_COFFEE_ENTRY_CODE.equals(serviceException.getMessage())) {
			coffeeResponse.setStatusCode(CoffeeStallConstants.PRECONDITION_FAILURE_STATUS_CODE);
			coffeeResponse.setStatusMessage(CoffeeStallConstants.PRECONDITION_FAILURE_MESSAGE);
		}
		return coffeeResponse;
	}

}
