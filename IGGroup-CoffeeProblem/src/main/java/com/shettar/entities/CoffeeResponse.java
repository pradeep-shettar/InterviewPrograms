/**
 * 
 */
package com.shettar.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pradeep.Shettar
 * 
 *         The entity class to hold the response constructed for coffee service.
 */
@JsonInclude
public class CoffeeResponse extends ServiceResponse {

	/**
	 * Default Constructor for the response of Coffee service.
	 */
	public CoffeeResponse() {
		super();
	}

	/**
	 * @param statusCode
	 * @param statusMessage
	 */
	public CoffeeResponse(String statusCode, String statusMessage) {
		super(statusCode, statusMessage);
	}

}
