/**
 * 
 */
package com.shettar.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pradeep.Shettar
 * 
 *         Entity class for Servings data.
 *
 */
@JsonInclude
public class CoffeeForTheDay {

	/**
	 * Default constructor for the serving class
	 */
	public CoffeeForTheDay() {
	}

	/**
	 * coffee to store the coffee type for the serving for the day entry.
	 */
	private Coffee coffee;
	/**
	 * servingDate to store the serving date.
	 */
	private Date servingDate;

	/**
	 * totalServings to store the total cups of servings available for the date.
	 */
	private Integer totalServings;

	/**
	 * servingsLeft to store the left over cups of servings for the date.
	 */
	private Integer servingsLeft;

	/**
	 * @return the coffee
	 */
	public Coffee getCoffee() {
		return coffee;
	}

	/**
	 * @param coffee
	 *            the coffee to set
	 */
	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	/**
	 * @return the servingDate
	 */
	public Date getServingDate() {
		return servingDate;
	}

	/**
	 * @param servingDate
	 *            the servingDate to set
	 */
	public void setServingDate(Date servingDate) {
		this.servingDate = servingDate;
	}

	/**
	 * @return the totalServings
	 */
	public Integer getTotalServings() {
		return totalServings;
	}

	/**
	 * @param totalServings
	 *            the totalServings to set
	 */
	public void setTotalServings(Integer totalServings) {
		this.totalServings = totalServings;
	}

	/**
	 * @return the servingsLeft
	 */
	public Integer getServingsLeft() {
		return servingsLeft;
	}

	/**
	 * @param servingsLeft
	 *            the servingsLeft to set
	 */
	public void setServingsLeft(Integer servingsLeft) {
		this.servingsLeft = servingsLeft;
	}

	/**
	 * @param coffee
	 * @param servingDate
	 * @param totalServings
	 * @param servingsLeft
	 */
	public CoffeeForTheDay(Coffee coffee, Date servingDate, Integer totalServings, Integer servingsLeft) {
		super();
		this.coffee = coffee;
		this.servingDate = servingDate;
		this.totalServings = totalServings;
		this.servingsLeft = servingsLeft;
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
		result = prime * result + ((coffee == null) ? 0 : coffee.hashCode());
		result = prime * result + ((servingDate == null) ? 0 : servingDate.hashCode());
		result = prime * result + ((servingsLeft == null) ? 0 : servingsLeft.hashCode());
		result = prime * result + ((totalServings == null) ? 0 : totalServings.hashCode());
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
		CoffeeForTheDay other = (CoffeeForTheDay) obj;
		if (coffee == null) {
			if (other.coffee != null)
				return false;
		} else if (!coffee.equals(other.coffee))
			return false;
		if (servingDate == null) {
			if (other.servingDate != null)
				return false;
		} else if (!servingDate.equals(other.servingDate))
			return false;
		if (servingsLeft == null) {
			if (other.servingsLeft != null)
				return false;
		} else if (!servingsLeft.equals(other.servingsLeft))
			return false;
		if (totalServings == null) {
			if (other.totalServings != null)
				return false;
		} else if (!totalServings.equals(other.totalServings))
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
		return "CoffeeForTheDay [coffee=" + coffee + ", servingDate=" + servingDate + ", totalServings=" + totalServings
				+ ", servingsLeft=" + servingsLeft + "]";
	}

	/**
	 * 
	 */
	public void decrementServings() {
		servingsLeft--;
	}

}
