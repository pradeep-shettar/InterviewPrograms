/**
 * 
 */
package com.shettar.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CustomerDao;
import com.shettar.entities.Customer;
import com.shettar.entities.CustomerResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.exceptions.ServiceException;
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
	CustomerDao customerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shettar.services.CustomerService#createCustomer(com.shettar.entities.
	 * Customer)
	 */
	@Override
	public CustomerResponse createCustomer(Customer customer) throws ServiceException {
		LOGGER.debug("Entered the createCustomer method of CustomerServiceImpl class with parameter: "
				.concat(customer == null ? null : customer.toString()));
		CustomerResponse customerResponse = new CustomerResponse();
		try {
			customerDao.createCustomer(customer);
		} catch (DaoException customerDaoException) {
			LOGGER.debug("Exception caught in createCustomer method of CustomerServiceImpl class\n"
					+ customerDaoException.toString());
			throw new ServiceException(CoffeeStallConstants.DATABASE_TRANSACTION_FAILURE_CODE);
		}
		LOGGER.debug("Exiting the createCustomer method of CustomerServiceImpl class with retruning value: "
				.concat(customerResponse == null ? null : customerResponse.toString()));
		return customerResponse;
	}

}
