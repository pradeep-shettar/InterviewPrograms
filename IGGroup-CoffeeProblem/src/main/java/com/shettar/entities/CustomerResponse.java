/**
 * 
 */
package com.shettar.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pradeep.Shettar
 *
 *         The entity class that stores the response for operation on customer
 *         creation.
 */

@JsonInclude
public class CustomerResponse extends ServiceResponse {

	/**
	 * Default constructor for Response for the customer creation operation.
	 */
	public CustomerResponse() {
	}

	/**
	 * @param statusCode
	 * @param statusMessage
	 */
	public CustomerResponse(String statusCode, String statusMessage) {
		super(statusCode, statusMessage);
	}

}
