/**
 * 
 */
package com.shettar.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shettar.entities.Customer;
import com.shettar.entities.CustomerResponse;
import com.shettar.services.CustomerService;

/**
 * @author Pradeep.Shettar
 *
 *         Controller class for adding a new customer.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

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
		CustomerResponse customerResponse = null;
		Customer createdCustomer = customerService.createCustomer(customer);
		return customerResponse;
	}
}
