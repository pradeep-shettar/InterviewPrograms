/**
 * 
 */
package com.shettar.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pradeep.Shettar
 * 
 *         The entity class that holds the reports for the day of the coffees
 *         sold.
 *
 */
@JsonInclude
public class ReportForTheDay extends ServiceResponse {

	/**
	 * Default constructor for reports for the day
	 */
	public ReportForTheDay() {
	}

	/**
	 * List of coffees data for the day.
	 */
	List<CoffeeForTheDay> coffeesForTheDay;

	/**
	 * @return the coffeesForTheDay
	 */
	public List<CoffeeForTheDay> getCoffeesForTheDay() {
		return coffeesForTheDay;
	}

	/**
	 * @param coffeesForTheDay the coffeesForTheDay to set
	 */
	public void setCoffeesForTheDay(List<CoffeeForTheDay> coffeesForTheDay) {
		this.coffeesForTheDay = coffeesForTheDay;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((coffeesForTheDay == null) ? 0 : coffeesForTheDay.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		ReportForTheDay other = (ReportForTheDay) obj;
		if (coffeesForTheDay == null) {
			if (other.coffeesForTheDay != null)
				return false;
		} else if (!coffeesForTheDay.equals(other.coffeesForTheDay))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportForTheDay [coffeesForTheDay=" + coffeesForTheDay + "]";
	}

	/**
	 * @param coffeesForTheDay
	 */
	public ReportForTheDay(String statusCode, String statusMessage, List<CoffeeForTheDay> coffeesForTheDay) {
		super(statusCode, statusMessage);
		this.coffeesForTheDay = coffeesForTheDay;
	}
}
