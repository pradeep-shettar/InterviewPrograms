/**
 * 
 */
package com.shettar.entities;

import java.util.List;

/**
 * @author Pradeep.Shettar
 *
 *         Entity class to store the receipt data.
 */
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
	 * @param coffeeOrders the coffeeOrders to set
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffeeOrders == null) ? 0 : coffeeOrders.hashCode());
		result = prime * result + ((receiptNumber == null) ? 0 : receiptNumber.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
		return result;
	}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Receipt [receiptNumber=" + receiptNumber + ", coffeeOrders=" + coffeeOrders + ", totalCost=" + totalCost
				+ "]";
	}

	/**
	 * @param receiptNumber
	 * @param coffeeOrders
	 * @param totalCost
	 */
	public Receipt(String receiptNumber, List<CoffeeOrder> coffeeOrders, Double totalCost) {
		super();
		this.receiptNumber = receiptNumber;
		this.coffeeOrders = coffeeOrders;
		this.totalCost = totalCost;
	}

}
