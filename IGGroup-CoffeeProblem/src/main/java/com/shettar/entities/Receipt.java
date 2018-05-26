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
 *         Entity class to store the receipt data.
 */
@JsonInclude
public class Receipt {

	/**
	 * Default constructor for the Receipt type.
	 */
	public Receipt() {
	}

	/**
	 * receiptNumber to store the unique id of the Receipt.
	 */
	private String receiptNumber;

	/**
	 * date when the receipt created.
	 */
	private Date receiptDate;

	/**
	 * Customer who placed the order.
	 */
	private Customer customer;

	/**
	 * order to store the order details made by the customer.
	 */
	private List<CoffeeOrder> coffeeOrders;

	/**
	 * totalCost to store the total cost of the orders made.
	 */
	private Double totalCost;

	/**
	 * @return the receiptNumber
	 */
	public String getReceiptNumber() {
		return receiptNumber;
	}

	/**
	 * @param receiptNumber
	 *            the receiptNumber to set
	 */
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	/**
	 * @return the coffeeOrders
	 */
	public List<CoffeeOrder> getCoffeeOrders() {
		return coffeeOrders;
	}

	/**
	 * @param coffeeOrders
	 *            the coffeeOrders to set
	 */
	public void setCoffeeOrders(List<CoffeeOrder> coffeeOrders) {
		this.coffeeOrders = coffeeOrders;
	}

	/**
	 * @return the totalCost
	 */
	public Double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the receiptDate
	 */
	public Date getReceiptDate() {
		return receiptDate;
	}

	/**
	 * @param receiptDate
	 *            the receiptDate to set
	 */
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffeeOrders == null) ? 0 : coffeeOrders.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((receiptDate == null) ? 0 : receiptDate.hashCode());
		result = prime * result + ((receiptNumber == null) ? 0 : receiptNumber.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
		Receipt other = (Receipt) obj;
		if (coffeeOrders == null) {
			if (other.coffeeOrders != null)
				return false;
		} else if (!coffeeOrders.equals(other.coffeeOrders))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (receiptDate == null) {
			if (other.receiptDate != null)
				return false;
		} else if (!receiptDate.equals(other.receiptDate))
			return false;
		if (receiptNumber == null) {
			if (other.receiptNumber != null)
				return false;
		} else if (!receiptNumber.equals(other.receiptNumber))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}

	/**
	 * @param receiptNumber
	 * @param receiptDate
	 * @param customer
	 * @param coffeeOrders
	 * @param totalCost
	 */
	public Receipt(String receiptNumber, Date receiptDate, Customer customer, List<CoffeeOrder> coffeeOrders,
			Double totalCost) {
		super();
		this.receiptNumber = receiptNumber;
		this.receiptDate = receiptDate;
		this.customer = customer;
		this.coffeeOrders = coffeeOrders;
		this.totalCost = totalCost;
	}

}
