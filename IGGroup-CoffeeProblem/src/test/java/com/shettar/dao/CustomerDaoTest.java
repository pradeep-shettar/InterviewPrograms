/**
 * 
 */
package com.shettar.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.shettar.builders.CustomerBuilder;
import com.shettar.constants.CoffeeStallConstants;
import com.shettar.daoImpl.CustomerDaoImpl;
import com.shettar.entities.Customer;
import com.shettar.exceptions.DaoException;

/**
 * @author Pradeep.Shettar
 *
 */
public class CustomerDaoTest {

	CustomerDaoImpl customerDao;
	private List<Customer> customers;

	@Before
	public void init() {
		customerDao = new CustomerDaoImpl();
	}

	@Test
	public void testCreateCustomerSuccessWhenListNull() {
		customerDao.setCustomers(customers);
		CustomerBuilder customerBuilder = new CustomerBuilder();
		Customer customer = customerBuilder.initialise().populateContactNumber("+919876543210").populateName("Pradeep")
				.construct();
		Exception exception = null;
		try {
			customerDao.createCustomer(customer);
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertEquals(null, exception);
		Assert.assertTrue(customerDao.getCustomers().contains(customer));
	}

	@Test
	public void testCreateCustomerDuplicateEntry() {
		customers = new ArrayList<>();
		customerDao.setCustomers(customers);
		CustomerBuilder customerBuilder = new CustomerBuilder();
		Customer customer = customerBuilder.initialise().populateContactNumber("+919876543210").populateName("Pradeep")
				.construct();
		customers.add(customer);
		Exception exception = null;
		try {
			customerDao.createCustomer(customer);
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNotNull(exception);
		Assert.assertTrue(exception instanceof DaoException);
		DaoException daoException = (DaoException) exception;
		Assert.assertEquals(CoffeeStallConstants.CREATING_DUPLICATE_CUSTOMER, daoException.getMessage());
	}
}
