/**
 * 
 */
package com.shettar.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.shettar.builders.CoffeeForTheDayBuilder;
import com.shettar.constants.CoffeeStallConstants;
import com.shettar.daoImpl.CoffeeDaoImpl;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.exceptions.DaoException;
import com.shettar.utilities.DateUtil;

/**
 * @author Pradeep.Shettar
 *
 */
public class CoffeeDaoTest {

	CoffeeDaoImpl coffeeDaoImpl;
	private List<CoffeeForTheDay> listOfCoffees;

	@Before
	public void initailise() {
		coffeeDaoImpl = new CoffeeDaoImpl();
	}

	@Test
	public void testLoadCustomerDetailsForNoEntryInDBSuccess() {
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");
		Exception exception = null;
		try {
			coffeeDaoImpl.loadCoffeeForTheDay(coffeeForTheDay);
		} catch (DaoException e) {
			exception = e;
		}

		Assert.assertEquals(null, exception);
	}

	@Test
	public void testLoadCustomerDetailsSuccess() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		Exception exception = null;
		try {
			coffeeDaoImpl.loadCoffeeForTheDay(coffeeForTheDay);
		} catch (DaoException e) {
			exception = e;
		}

		Assert.assertEquals(null, exception);
	}

	@Test
	public void testLoadCustomerDetailsExisitingData() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);

		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		Exception exception = null;
		try {
			coffeeDaoImpl.loadCoffeeForTheDay(coffeeForTheDay);
		} catch (DaoException daoException) {
			exception = daoException;
		}

		Assert.assertNotNull(exception);
		Assert.assertTrue(exception instanceof DaoException);
		DaoException daoException = (DaoException) exception;
		Assert.assertEquals(CoffeeStallConstants.CREATING_DUPLICATE_COFFEE_ENTRY_CODE, daoException.getMessage());
	}

	@Test
	public void testGetCoffeeForTheDaySuccess() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		Exception exception = null;
		CoffeeForTheDay coffeeForTheDayFromDB = null;
		try {
			coffeeForTheDayFromDB = coffeeDaoImpl.getCoffeeForTheDay("Espresso",
					DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"));
		} catch (DaoException daoException) {
			exception = daoException;
		}

		Assert.assertEquals(coffeeForTheDay, coffeeForTheDayFromDB);
		Assert.assertNull(exception);
	}

	@Test
	public void testGetCoffeeForTheDayNotFound() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		Exception exception = null;
		CoffeeForTheDay coffeeForTheDayFromDB = null;
		try {
			coffeeForTheDayFromDB = coffeeDaoImpl.getCoffeeForTheDay("Caffè Americano",
					DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"));
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNull(coffeeForTheDayFromDB);
		Assert.assertNotNull(exception);
		Assert.assertTrue(exception instanceof DaoException);
		DaoException daoException = (DaoException) exception;
		Assert.assertEquals(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE, daoException.getMessage());
	}

	@Test
	public void testGetCoffeeForTheDayAvailableForDifferentDate() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		Exception exception = null;
		CoffeeForTheDay coffeeForTheDayFromDB = null;
		try {
			coffeeForTheDayFromDB = coffeeDaoImpl.getCoffeeForTheDay("Espresso",
					DateUtil.constructDate("28-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"));
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNull(coffeeForTheDayFromDB);
		Assert.assertNotNull(exception);
		Assert.assertTrue(exception instanceof DaoException);
		DaoException daoException = (DaoException) exception;
		Assert.assertEquals(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE, daoException.getMessage());
	}

	@Test
	public void testGetCoffeeForTheDaySOldOut() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(0).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		Exception exception = null;
		CoffeeForTheDay coffeeForTheDayFromDB = null;
		try {
			coffeeForTheDayFromDB = coffeeDaoImpl.getCoffeeForTheDay("Espresso",
					DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"));
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNull(coffeeForTheDayFromDB);
		Assert.assertNotNull(exception);
		Assert.assertTrue(exception instanceof DaoException);
		DaoException daoException = (DaoException) exception;
		Assert.assertEquals(CoffeeStallConstants.COFFEE_SOLD_OUT_CODE, daoException.getMessage());
	}

	@Test
	public void testUpdateCoffeeForTheDayForSuccess() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		// Updated value of the CoffeeForTheDay instance.
		coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeToUpdate = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T15:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(99).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		Exception exception = null;

		try {
			coffeeDaoImpl.updateCoffeeForTheDay(coffeeToUpdate);
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNull(exception);
		CoffeeForTheDay coffee = listOfCoffees.get(0);
		Assert.assertEquals(coffeeToUpdate.getServingsLeft(), coffee.getServingsLeft());
	}

	@Test
	public void testUpdateCoffeeForTheDayForNoData() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		// Updated value of the CoffeeForTheDay instance.
		coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeToUpdate = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T15:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(99).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Caffè Americano")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		Exception exception = null;

		try {
			coffeeDaoImpl.updateCoffeeForTheDay(coffeeToUpdate);
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNotNull(exception);
		Assert.assertTrue(exception instanceof DaoException);
		DaoException daoException = (DaoException) exception;
		Assert.assertEquals(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE, daoException.getMessage());
	}

	@Test
	public void testGetAllCoffeesForTheDaySuccessScenario() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);
		CoffeeForTheDayBuilder coffeeForTheDayBuilderTwo = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayTwo = coffeeForTheDayBuilderTwo.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderTwo.new CoffeeBuilder().initialise().populateCoffeeName("Caffè Americano")
				.populateCost(new Double(40))
				.populateDescription("Simply by adding hot water to a shot of espresso coffee");

		listOfCoffees.add(coffeeForTheDayTwo);

		CoffeeForTheDayBuilder coffeeForTheDayBuilderThree = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayThree = coffeeForTheDayBuilderThree.initialise()
				.populateServingDate(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderThree.new CoffeeBuilder().initialise().populateCoffeeName("Cappuccino")
				.populateCost(new Double(50)).populateDescription(
						"Composed of double espresso and hot milk, with the surface topped with foamed milk");

		listOfCoffees.add(coffeeForTheDayThree);

		CoffeeForTheDayBuilder coffeeForTheDayBuilderFour = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayFour = coffeeForTheDayBuilderFour.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderFour.new CoffeeBuilder().initialise().populateCoffeeName("Strong Coffee")
				.populateCost(new Double(20)).populateDescription("Simple coffee");

		listOfCoffees.add(coffeeForTheDayFour);

		Exception exception = null;
		List<CoffeeForTheDay> allCoffeeForTheDay = null;
		try {
			allCoffeeForTheDay = coffeeDaoImpl
					.getAllCoffeeForTheDay(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"));
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNull(exception);
		Assert.assertNotNull(allCoffeeForTheDay);
		Assert.assertTrue(allCoffeeForTheDay.contains(coffeeForTheDay));
		Assert.assertTrue(allCoffeeForTheDay.contains(coffeeForTheDayTwo));
		Assert.assertTrue(allCoffeeForTheDay.contains(coffeeForTheDayThree));
		Assert.assertFalse(allCoffeeForTheDay.contains(coffeeForTheDayFour));
	}

	@Test
	public void testGetAllCoffeesForTheDayNoEntries() {
		listOfCoffees = null;
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		Exception exception = null;
		List<CoffeeForTheDay> allCoffeeForTheDay = null;
		try {
			allCoffeeForTheDay = coffeeDaoImpl
					.getAllCoffeeForTheDay(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"));
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNotNull(exception);
		Assert.assertNull(allCoffeeForTheDay);
		DaoException daoException = (DaoException) exception;
		Assert.assertEquals(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE, daoException.getMessage());
	}

	@Test
	public void testGetAllCoffeesForTheDayEmptyEntries() {
		listOfCoffees = new ArrayList<>();
		coffeeDaoImpl.setListOfCoffees(listOfCoffees);
		Exception exception = null;
		List<CoffeeForTheDay> allCoffeeForTheDay = null;
		try {
			allCoffeeForTheDay = coffeeDaoImpl
					.getAllCoffeeForTheDay(DateUtil.constructDate("27-05-2018T12:30:00", "dd-MM-yyyy'T'HH:mm:ss"));
		} catch (DaoException daoException) {
			exception = daoException;
		}
		Assert.assertNotNull(exception);
		Assert.assertNull(allCoffeeForTheDay);
		DaoException daoException = (DaoException) exception;
		Assert.assertEquals(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE, daoException.getMessage());
	}
}
