/**
 * 
 */
package com.shettar.entities;

/**
 * @author Pradeep.Shettar
 *
 *         The Entity class for coffee.
 */
public class Coffee {

	/**
	 * Default constructor for entity class.
	 */
	public Coffee() {

	}

	/**
	 * coffeeName to store the name of the Coffee.
	 */
	private String coffeeName;

	/**
	 * description to store the description of the coffee.
	 */
	private String description;

	/**
	 * cost to store the cost of the coffee.
	 */
	private Double cost;

	/**
	 * @return the coffeeName
	 */
	public String getCoffeeName() {
		return coffeeName;
	}

	/**
	 * @param coffeeName the coffeeName to set
	 */
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * @param coffeeName
	 * @param description
	 * @param cost
	 */
	public Coffee(String coffeeName, String description, Double cost) {
		super();
		this.coffeeName = coffeeName;
		this.description = description;
		this.cost = cost;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffeeName == null) ? 0 : coffeeName.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Coffee other = (Coffee) obj;
		if (coffeeName == null) {
			if (other.coffeeName != null)
				return false;
		} else if (!coffeeName.equals(other.coffeeName))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coffee [coffeeName=" + coffeeName + ", description=" + description + ", cost=" + cost + "]";
	}

}
