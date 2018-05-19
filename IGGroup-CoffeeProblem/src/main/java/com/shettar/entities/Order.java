/**
 * 
 */
package com.shettar.entities;

import java.util.Date;
import java.util.Map;

/**
 * @author Pradeep.Shettar
 *
 *         Entity class for storing the order details.
 */
public class Order {

	/**
	 * The default constructor for the order class.
	 */
	public Order() {
	}

	/**
	 * orderDate to store the date on which the order was made.
	 */
	private Date orderDate;

	/**
	 * customer to store the customer who made the order.
	 */
	private Customer customer;

	/**
	 * orderMap to store the coffees and count of coffees ordered by the
	 * customer.
	 */
	private Map<Coffee, Integer> orderMap;

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
	 * @return the orderMap
	 */
	public Map<Coffee, Integer> getOrderMap() {
		return orderMap;
	}

	/**
	 * @param orderMap
	 *            the orderMap to set
	 */
	public void setOrderMap(Map<Coffee, Integer> orderMap) {
		this.orderMap = orderMap;
	}

	/**
	 * @param orderDate
	 * @param customer
	 * @param orderMap
	 */
	public Order(Date orderDate, Customer customer, Map<Coffee, Integer> orderMap) {
		super();
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderMap = orderMap;
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
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderMap == null) ? 0 : orderMap.hashCode());
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
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderMap == null) {
			if (other.orderMap != null)
				return false;
		} else if (!orderMap.equals(other.orderMap))
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
		return "Order [orderDate=" + orderDate + ", customer=" + customer + ", orderMap=" + orderMap + "]";
	}

}
