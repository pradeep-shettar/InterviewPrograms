/**
 * 
 */
package com.shettar.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CustomerDao;
import com.shettar.entities.Customer;
import com.shettar.exceptions.DaoException;

/**
 * @author Pradeep.Shettar
 *
 */
public class CustomerDaoImpl implements CustomerDao {

	/**
	 * list of customers in stored.
	 */
	private List<Customer> customers;
	
	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * Logger object for class level logging.
	 */
	private Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shettar.dao.CustomerDao#createCustomer(com.shettar.entities.Customer)
	 */
	@Override
	public void createCustomer(Customer customer) throws DaoException {
		LOGGER.debug("Entered createCustomer method of CustomerDaoImpl class with parameter: " + customer.toString());
		if (customers == null) {
			customers = new ArrayList<>();
		}
		if (customers.contains(customer)) {
			LOGGER.error("Trying to create a customer whose data already exists!");
			throw new DaoException(CoffeeStallConstants.CREATING_DUPLICATE_CUSTOMER);
		}
		customers.add(customer);
		LOGGER.debug("Exiting createCustomer method of CustomerDaoImpl class");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.dao.CustomerDao#getCustomer(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Customer getCustomer(String customerName, String customerContactNumber) throws DaoException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.dao.CustomerDao#updatedCustomer(com.shettar.entities.
	 * Customer)
	 */
	@Override
	public Customer updatedCustomer(Customer customer) throws DaoException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shettar.dao.CustomerDao#removeCustomer(com.shettar.entities.Customer)
	 */
	@Override
	public void removeCustomer(Customer customer) throws DaoException {

	}

}
