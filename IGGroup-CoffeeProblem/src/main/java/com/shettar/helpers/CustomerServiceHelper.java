/**
 * 
 */
package com.shettar.helpers;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.CustomerResponse;
import com.shettar.exceptions.ServiceException;

/**
 * @author Pradeep.Shettar
 *
 *         Helper class for customer service.
 */
public class CustomerServiceHelper {

	/**
	 * @param serviceException
	 * @return
	 */
	public static CustomerResponse handleServiceException(ServiceException serviceException) {
		CustomerResponse customerResponse = new CustomerResponse();
		if (serviceException.getMessage().equals(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE_CODE)) {
			customerResponse.setStatusCode(CoffeeStallConstants.INTERNAL_SERVER_ERROR_STATUS_CODE);
			customerResponse.setStatusMessage(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE);
		}
		else if (serviceException.getMessage().equals(CoffeeStallConstants.CREATING_DUPLICATE_CUSTOMER)) {
			customerResponse.setStatusCode(CoffeeStallConstants.INTERNAL_SERVER_ERROR_STATUS_CODE);
			customerResponse.setStatusMessage(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE);
		}
		return customerResponse;
	}

	
}
