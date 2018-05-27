/**
 * 
 */
package com.shettar.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CustomerDao;
import com.shettar.entities.Customer;
import com.shettar.entities.CustomerResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.helpers.CustomerServiceHelper;
import com.shettar.services.CustomerService;

/**
 * @author Pradeep.Shettar
 *
 */
public class CustomerServiceImpl implements CustomerService {

	/**
	 * Logger type for class level logging.
	 */
	private Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	/**
	 * CustomerDao type for customer data transactions.
	 */
	@Autowired
	CustomerDao customerDao;

	/**
	 * @return the customerDao
	 */
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	/**
	 * @param customerDao
	 *            the customerDao to set
	 */
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shettar.services.CustomerService#createCustomer(com.shettar.entities.
	 * Customer)
	 */
	@Override
	public CustomerResponse createCustomer(Customer customer) {
		LOGGER.debug("Entered the createCustomer method of CustomerServiceImpl class with parameter: "
				.concat(customer == null ? null : customer.toString()));
		CustomerResponse customerResponse = new CustomerResponse();
		try {
			customerDao.createCustomer(customer);
		} catch (DaoException customerDaoException) {
			LOGGER.debug("Exception caught in createCustomer method of CustomerServiceImpl class\n"
					+ customerDaoException.toString());
			return CustomerServiceHelper.handleServiceException(customerDaoException.getMessage());
		}
		customerResponse.setStatusCode(CoffeeStallConstants.CREATED_STATUS_CODE);
		customerResponse.setStatusMessage(CoffeeStallConstants.CUSTOMER_CREATED_MESSAGE);
		LOGGER.debug("Exiting the createCustomer method of CustomerServiceImpl class with retruning value: "
				.concat(customerResponse == null ? null : customerResponse.toString()));
		return customerResponse;
	}

}
