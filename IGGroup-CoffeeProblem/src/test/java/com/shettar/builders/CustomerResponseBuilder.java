/**
 * 
 */
package com.shettar.builders;

import com.shettar.entities.CustomerResponse;

/**
 * @author Pradeep.Shettar
 *
 */
public class CustomerResponseBuilder {

	CustomerResponse customerResponse;

	public CustomerResponseBuilder initialise() {
		customerResponse = new CustomerResponse();
		return this;
	}

	public CustomerResponseBuilder populateStatus(String statusCode) {
		customerResponse.setStatusCode(statusCode);
		return this;
	}

	public CustomerResponseBuilder populateStatusMessage(String statusMessage) {
		customerResponse.setStatusMessage(statusMessage);
		return this;
	}

	public CustomerResponse construct() {
		return customerResponse;
	}
}
