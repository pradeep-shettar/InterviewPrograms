/**
 * 
 */
package com.shettar.builders;

import java.util.Date;

import com.shettar.entities.Coffee;
import com.shettar.entities.CoffeeForTheDay;

/**
 * @author Pradeep.Shettar
 *
 *         Builder class for CoffeeForTheDay entity.
 */
public class CoffeeForTheDayBuilder {

	private CoffeeForTheDay coffeeForTheDay;

	public CoffeeForTheDayBuilder initialise() {
		coffeeForTheDay = new CoffeeForTheDay();
		return this;
	}

	public CoffeeForTheDayBuilder populateServingsLeft(Integer servingsLeftParam) {
		coffeeForTheDay.setServingsLeft(servingsLeftParam);
		return this;
	}

	public CoffeeForTheDayBuilder populateTotalServings(Integer totalServingsParam) {
		coffeeForTheDay.setTotalServings(totalServingsParam);
		return this;
	}

	public CoffeeForTheDayBuilder populateServingDate(Date servingDate) {
		coffeeForTheDay.setServingDate(servingDate);
		return this;
	}

	public CoffeeForTheDay construct() {
		return coffeeForTheDay;
	}

	public class CoffeeBuilder {
		private Coffee coffee;

		public CoffeeBuilder initialise() {
			coffee = new Coffee();
			coffeeForTheDay.setCoffee(coffee);
			return this;
		}

		public CoffeeBuilder populateCoffeeName(String coffeeNameParam) {
			coffee.setCoffeeName(coffeeNameParam);
			return this;
		}

		public CoffeeBuilder populateCost(Double costParam) {
			coffee.setCost(costParam);
			return this;
		}

		public CoffeeBuilder populateDescription(String descriptionParam) {
			coffee.setDescription(descriptionParam);
			return this;
		}

		public Coffee construct() {
			return coffee;
		}
	}
}
