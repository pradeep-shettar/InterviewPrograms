/**
 * 
 */
package com.shettar.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.shettar.builders.CustomerBuilder;
import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CustomerDao;
import com.shettar.entities.Customer;
import com.shettar.entities.CustomerResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.servicesImpl.CustomerServiceImpl;

/**
 * @author Pradeep.Shettar
 *
 */
public class CustomerServiceTest {

	CustomerServiceImpl customerService;

	CustomerDao customerDao;

	@Before
	public void init() {
		customerService = new CustomerServiceImpl();
		customerDao = Mockito.mock(CustomerDao.class);
		customerService.setCustomerDao(customerDao);
	}

	@Test
	public void testCreateCustomer() {
		CustomerBuilder customerBuilder = new CustomerBuilder();
		Customer customer = customerBuilder.initialise().populateContactNumber("+919876543210").populateName("Pradeep")
				.construct();
		CustomerResponse customerResponse = customerService.createCustomer(customer);
		Assert.assertEquals(CoffeeStallConstants.CREATED_STATUS_CODE, customerResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.CUSTOMER_CREATED_MESSAGE, customerResponse.getStatusMessage());
	}

	@Test
	public void testCreateCustomerDuplicateCreationFailure() {

		DaoException daoException = new DaoException(CoffeeStallConstants.CREATING_DUPLICATE_CUSTOMER);
		try {
			Mockito.doThrow(daoException).when(customerDao).createCustomer(Mockito.any(Customer.class));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		CustomerBuilder customerBuilder = new CustomerBuilder();
		Customer customer = customerBuilder.initialise().populateContactNumber("+919876543210").populateName("Pradeep")
				.construct();
		CustomerResponse customerResponse = customerService.createCustomer(customer);
		Assert.assertEquals(CoffeeStallConstants.INTERNAL_SERVER_ERROR_STATUS_CODE, customerResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE, customerResponse.getStatusMessage());
	}

}
