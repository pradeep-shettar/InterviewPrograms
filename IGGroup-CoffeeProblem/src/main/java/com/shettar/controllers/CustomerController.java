/**
 * 
 */
package com.shettar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shettar.entities.Customer;
import com.shettar.entities.CustomerResponse;
import com.shettar.exceptions.ServiceException;
import com.shettar.helpers.CustomerServiceHelper;
import com.shettar.services.CustomerService;

/**
 * @author Pradeep.Shettar
 *
 *         Controller class for adding a new customer.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	/**
	 * Logger object for logging at class level
	 */
	Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	/**
	 * customerService object for customer service.
	 */
	private CustomerService customerService;

	/**
	 * The controller method creates and stores the customer data if the
	 * customer data is not stored.
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerResponse createCustomer(@RequestBody Customer customer) {
		LOGGER.debug(
				"Entered createCustomer method of CustomerController class with parameter: " + customer.toString());
		CustomerResponse customerResponse = null;
		try {
			customerResponse = customerService.createCustomer(customer);
		} catch (ServiceException serviceException) {
			LOGGER.error("serviceException caught in createCustomer method of CustomerController class\n"
					+ serviceException.toString());
			customerResponse = CustomerServiceHelper.handleServiceException(serviceException);
		}
		LOGGER.debug("Exiting createCustomer method of CustomerController class with returning value: "
				+ customerResponse.toString());
		return customerResponse;
	}
}
