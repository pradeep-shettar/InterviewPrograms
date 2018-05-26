/**
 * 
 */
package com.shettar.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pradeep.Shettar
 *
 */
@JsonInclude
public class CoffeeOrder {

	/**
	 * 
	 */
	public CoffeeOrder() {
	}
	
	/**
	 * name of the coffee.
	 */
	private String coffeeName;
	
	/**
	 * total number of coffees orders of same type.
	 */
	private Integer count;

	/**
	 * @return
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffeeName == null) ? 0 : coffeeName.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
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
		CoffeeOrder other = (CoffeeOrder) obj;
		if (coffeeName == null) {
			if (other.coffeeName != null)
				return false;
		} else if (!coffeeName.equals(other.coffeeName))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CoffeeOrder [coffeeName=" + coffeeName + ", count=" + count + "]";
	}

	/**
	 * @param coffeeName
	 * @param count
	 */
	public CoffeeOrder(String coffeeName, Integer count) {
		super();
		this.coffeeName = coffeeName;
		this.count = count;
	}

}
