/**
 * 
 */
package com.shettar.helpers;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.CustomerResponse;

/**
 * @author Pradeep.Shettar
 *
 *         Helper class for customer service.
 */
public class CustomerServiceHelper {

	/**
	 * @param errorCode
	 * @param customer
	 * @return
	 */
	public static CustomerResponse handleServiceException(String errorCode) {
		CustomerResponse customerResponse = new CustomerResponse();
		if (errorCode.equals(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE_CODE)) {
			customerResponse.setStatusCode(CoffeeStallConstants.INTERNAL_SERVER_ERROR_STATUS_CODE);
			customerResponse.setStatusMessage(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE);
		}
		else if (errorCode.equals(CoffeeStallConstants.CREATING_DUPLICATE_CUSTOMER)) {
			customerResponse.setStatusCode(CoffeeStallConstants.INTERNAL_SERVER_ERROR_STATUS_CODE);
			customerResponse.setStatusMessage(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE);
		}
		return customerResponse;
	}

	
}
