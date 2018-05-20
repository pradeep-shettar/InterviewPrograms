/**
 * 
 */
package com.shettar.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pradeep.Shettar
 * 
 *         The entity class to hold the response constructed for coffee service.
 */
@JsonInclude
public class CoffeeResponse extends ServiceResponse {

	/**
	 * Default Constructor for the response of Coffee service.
	 */
	public CoffeeResponse() {
	}

	/**
	 * coffeeForTheDay to store the coffee for the day entry.
	 */
	private CoffeeForTheDay coffeeForTheDay;

	/**
	 * @return the coffeeForTheDay
	 */
	public CoffeeForTheDay getCoffeeForTheDay() {
		return coffeeForTheDay;
	}

	/**
	 * @param coffeeForTheDay
	 *            the coffeeForTheDay to set
	 */
	public void setCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay) {
		this.coffeeForTheDay = coffeeForTheDay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((coffeeForTheDay == null) ? 0 : coffeeForTheDay.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((statusMessage == null) ? 0 : statusMessage.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeResponse other = (CoffeeResponse) obj;
		if (coffeeForTheDay == null) {
			if (other.coffeeForTheDay != null)
				return false;
		} else if (!coffeeForTheDay.equals(other.coffeeForTheDay))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (statusMessage == null) {
			if (other.statusMessage != null)
				return false;
		} else if (!statusMessage.equals(other.statusMessage))
			return false;
		return true;
	}

	/**
	 * @param statusCode
	 * @param statusMessage
	 * @param coffeeForTheDay
	 */
	public CoffeeResponse(String statusCode, String statusMessage, CoffeeForTheDay coffeeForTheDay) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.coffeeForTheDay = coffeeForTheDay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CoffeeResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", coffeeForTheDay="
				+ coffeeForTheDay + "]";
	}

}
