/**
 * 
 */
package com.shettar.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.shettar.builders.CoffeeForTheDayBuilder;
import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.servicesImpl.CoffeeServiceImpl;
import com.shettar.utilities.DateUtil;

/**
 * @author Pradeep.Shettar
 *
 */
public class CoffeeServiceTest {

	CoffeeServiceImpl coffeeService;

	CoffeeDao coffeeDao;

	@Before
	public void initialise() {
		coffeeService = new CoffeeServiceImpl();
		coffeeDao = Mockito.mock(CoffeeDao.class);
		coffeeService.setCoffeeDao(coffeeDao);
	}

	@Test
	public void testCoffeeServiceSuccessScenario() {
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();

		// CoffeeForTheDay instance.
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		CoffeeResponse addCoffeeForTheDayResponse = coffeeService.addCoffeeForTheDay(coffeeForTheDay);

		Assert.assertEquals(CoffeeStallConstants.CREATED_STATUS_CODE, addCoffeeForTheDayResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.CREATED_COFFEE_MESSAGE, addCoffeeForTheDayResponse.getStatusMessage());
	}

	@Test
	public void testCoffeeServiceDuplicateInsertionScenario() {
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();

		// CoffeeForTheDay instance.
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		DaoException daoException = new DaoException(CoffeeStallConstants.CREATING_DUPLICATE_COFFEE_ENTRY_CODE);

		// Mock for dao.
		try {
			Mockito.doThrow(daoException).when(coffeeDao).loadCoffeeForTheDay(Mockito.any(CoffeeForTheDay.class));
		} catch (DaoException e) {
			e.printStackTrace();
		}

		CoffeeResponse addCoffeeForTheDayResponse = coffeeService.addCoffeeForTheDay(coffeeForTheDay);

		Assert.assertEquals(CoffeeStallConstants.PRECONDITION_FAILURE_STATUS_CODE,
				addCoffeeForTheDayResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.PRECONDITION_FAILURE_MESSAGE,
				addCoffeeForTheDayResponse.getStatusMessage());
	}
}
