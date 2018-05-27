/**
 * 
 */
package com.shettar.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.shettar.builders.CoffeeForTheDayBuilder;
import com.shettar.builders.CoffeeResponseBuilder;
import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeResponse;
import com.shettar.services.CoffeeService;
import com.shettar.utilities.DateUtil;

/**
 * @author Pradeep.Shettar
 *
 */
public class CoffeeControllerTest {

	CoffeeController coffeeController;

	CoffeeService coffeeService;

	@Before
	public void initialise() {
		coffeeController = new CoffeeController();
		coffeeService = Mockito.mock(CoffeeService.class);
		coffeeController.setCoffeeService(coffeeService);
	}

	@Test
	public void testSuccessScenario() {
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();

		// CoffeeForTheDay instance.
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		CoffeeResponseBuilder coffeeResponseBuilder = new CoffeeResponseBuilder();
		CoffeeResponse coffeeResponse = coffeeResponseBuilder.initialise()
				.populateStatusCode(CoffeeStallConstants.CREATED_STATUS_CODE)
				.populateStatusMessage(CoffeeStallConstants.CREATED_COFFEE_MESSAGE).construct();

		// Mocks
		Mockito.when(coffeeService.addCoffeeForTheDay(Mockito.any(CoffeeForTheDay.class))).thenReturn(coffeeResponse);
		CoffeeResponse addCoffeeForTheDay = coffeeController.addCoffeeForTheDay(coffeeForTheDay);
		Assert.assertEquals(CoffeeStallConstants.CREATED_STATUS_CODE, addCoffeeForTheDay.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.CREATED_COFFEE_MESSAGE, addCoffeeForTheDay.getStatusMessage());
	}

	@Test
	public void testDuplicateEntryAttempt() {
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();

		// CoffeeForTheDay instance.
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		CoffeeResponseBuilder coffeeResponseBuilder = new CoffeeResponseBuilder();
		CoffeeResponse coffeeResponse = coffeeResponseBuilder.initialise()
				.populateStatusCode(CoffeeStallConstants.PRECONDITION_FAILURE_STATUS_CODE)
				.populateStatusMessage(CoffeeStallConstants.PRECONDITION_FAILURE_MESSAGE).construct();

		// Mocks
		Mockito.when(coffeeService.addCoffeeForTheDay(Mockito.any(CoffeeForTheDay.class))).thenReturn(coffeeResponse);
		CoffeeResponse addCoffeeForTheDay = coffeeController.addCoffeeForTheDay(coffeeForTheDay);
		Assert.assertEquals(CoffeeStallConstants.PRECONDITION_FAILURE_STATUS_CODE, addCoffeeForTheDay.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.PRECONDITION_FAILURE_MESSAGE, addCoffeeForTheDay.getStatusMessage());
	}

}
