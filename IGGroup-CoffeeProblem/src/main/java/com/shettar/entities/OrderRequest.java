/**
 * 
 */
package com.shettar.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pradeep.Shettar
 *
 *         Entity class to hold the request type of the order made by the
 *         customer.
 */
@JsonInclude
public class OrderRequest {

	/**
	 * 
	 */
	public OrderRequest() {
	}

	private Date date;

	private Customer customer;

	private List<CoffeeOrder> coffees;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the coffees
	 */
	public List<CoffeeOrder> getCoffees() {
		return coffees;
	}

	/**
	 * @param coffees
	 *            the coffees to set
	 */
	public void setCoffees(List<CoffeeOrder> coffees) {
		this.coffees = coffees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffees == null) ? 0 : coffees.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderRequest other = (OrderRequest) obj;
		if (coffees == null) {
			if (other.coffees != null)
				return false;
		} else if (!coffees.equals(other.coffees))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderRequest [date=" + date + ", customer=" + customer + ", coffees=" + coffees + "]";
	}

	/**
	 * @param date
	 * @param customer
	 * @param coffees
	 */
	public OrderRequest(Date date, Customer customer, List<CoffeeOrder> coffees) {
		super();
		this.date = date;
		this.customer = customer;
		this.coffees = coffees;
	}

}
