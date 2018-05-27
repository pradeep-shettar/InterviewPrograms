/**
 * 
 */
package com.shettar.services;

import com.shettar.entities.Customer;
import com.shettar.entities.CustomerResponse;
import com.shettar.exceptions.ServiceException;

/**
 * @author Pradeep.Shettar
 *
 *         The service class for handling customer services.
 */
public interface CustomerService {

	/**
	 * The method that creates an instance of customer if the customer instance
	 * is not already created and stored.
	 * 
	 * @param customer
	 * 
	 * @return the constructed customer entry.
	 * @throws ServiceException
	 */
	public CustomerResponse createCustomer(Customer customer);
}
