/**
 * 
 */
package com.shettar.builders;

import com.shettar.entities.CoffeeResponse;

/**
 * @author Pradeep.Shettar
 *
 *         Builder class for constructing CoffeeResponse type.
 */
public class CoffeeResponseBuilder {

	/**
	 * Coffee Response object.
	 */
	CoffeeResponse coffeeResponse;

	/**
	 * @return
	 */
	public CoffeeResponseBuilder initialise() {
		coffeeResponse = new CoffeeResponse();
		return this;
	}

	/**
	 * @param statusCodeParam
	 * @return
	 */
	public CoffeeResponseBuilder populateStatusCode(String statusCodeParam) {
		coffeeResponse.setStatusCode(statusCodeParam);
		return this;
	}

	/**
	 * @param statusMessageParam
	 * @return
	 */
	public CoffeeResponseBuilder populateStatusMessage(String statusMessageParam) {
		coffeeResponse.setStatusMessage(statusMessageParam);
		return this;
	}

	/**
	 * @return
	 */
	public CoffeeResponse construct() {
		return coffeeResponse;
	}
}
