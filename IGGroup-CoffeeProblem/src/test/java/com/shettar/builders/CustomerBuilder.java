/**
 * 
 */
package com.shettar.builders;

import com.shettar.entities.Customer;

/**
 * @author Pradeep.Shettar
 *
 */
public class CustomerBuilder {

	Customer customer;
	
	public CustomerBuilder initialise() {
		customer = new Customer();
		return this;
	}
	
	public CustomerBuilder populateContactNumber(String contactNumber) {
		customer.setContactNumber(contactNumber);
		return this;
	}
	
	public CustomerBuilder populateName(String name) {
		customer.setName(name);
		return this;
	}
	
	public Customer construct() {
		return customer;
	}
}


