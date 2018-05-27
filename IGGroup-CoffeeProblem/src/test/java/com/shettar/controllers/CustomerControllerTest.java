/**
 * 
 */
package com.shettar.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.shettar.builders.CustomerBuilder;
import com.shettar.builders.CustomerResponseBuilder;
import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.Customer;
import com.shettar.entities.CustomerResponse;
import com.shettar.services.CustomerService;

/**
 * @author Pradeep.Shettar
 *
 */
public class CustomerControllerTest {

	CustomerController customerController;

	CustomerService customerService;

	@Before
	public void initialise() {
		customerController = new CustomerController();

		customerService = Mockito.mock(CustomerService.class);
		customerController.setCustomerService(customerService);
	}

	@Test
	public void testCreateCustomerSuccess() {
		CustomerResponseBuilder customerResponseBuilder = new CustomerResponseBuilder();

		CustomerResponse customerResponse = customerResponseBuilder.initialise()
				.populateStatus(CoffeeStallConstants.CREATED_STATUS_CODE)
				.populateStatusMessage(CoffeeStallConstants.CUSTOMER_CREATED_MESSAGE).construct();
		Mockito.when(customerService.createCustomer(Mockito.any(Customer.class))).thenReturn(customerResponse);
		CustomerBuilder customerBuilder = new CustomerBuilder();
		Customer customer = customerBuilder.initialise().populateContactNumber("+919876543210")
				.populateName("Pradeep").construct();
		CustomerResponse createCustomerResponse = customerController.createCustomer(customer);

		Assert.assertEquals(CoffeeStallConstants.CREATED_STATUS_CODE, createCustomerResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.CUSTOMER_CREATED_MESSAGE, createCustomerResponse.getStatusMessage());
	}

	@Test
	public void testCreateCustomerDBFailure() {
		CustomerResponseBuilder customerResponseBuilder = new CustomerResponseBuilder();

		CustomerResponse customerResponse = customerResponseBuilder.initialise()
				.populateStatus(CoffeeStallConstants.INTERNAL_SERVER_ERROR_STATUS_CODE)
				.populateStatusMessage(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE).construct();
		Mockito.when(customerService.createCustomer(Mockito.any(Customer.class))).thenReturn(customerResponse);
		CustomerBuilder customerBuilder = new CustomerBuilder();
		Customer customer = customerBuilder.initialise().populateContactNumber("+919876543210")
				.populateName("Pradeep").construct();
		CustomerResponse createCustomerResponse = customerController.createCustomer(customer);

		Assert.assertEquals(CoffeeStallConstants.INTERNAL_SERVER_ERROR_STATUS_CODE,
				createCustomerResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE,
				createCustomerResponse.getStatusMessage());
	}

}
