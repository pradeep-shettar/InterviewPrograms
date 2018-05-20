/**
 * 
 */
package com.shettar.dao;

import com.shettar.entities.Customer;
import com.shettar.exceptions.DaoException;

/**
 * @author Pradeep.Shettar
 *
 *         Data access object interface for Customer type.
 */
public interface CustomerDao {

	/**
	 * createCustomer method to create a customer type and store it.
	 * 
	 * @param customer
	 * @throws DaoException
	 */
	public void createCustomer(Customer customer) throws DaoException;

	/**
	 * method to get customer from stored data from customerName and customer
	 * contact number.
	 * 
	 * @param customerName
	 * @param customerContactNumber
	 * @return
	 * @throws DaoException
	 */
	public Customer getCustomer(String customerName, String customerContactNumber) throws DaoException;

	/**
	 * Method to Update the customer details
	 * 
	 * @param customer
	 * @return
	 * @throws DaoException
	 */
	public Customer updatedCustomer(Customer customer) throws DaoException;

	/**
	 * Method to remove the customer details from stored data.
	 * 
	 * @param customer
	 * @throws DaoException
	 */
	public void removeCustomer(Customer customer) throws DaoException;
}
