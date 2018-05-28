/**
 * 
 */
package com.shettar.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.shettar.builders.CoffeeForTheDayBuilder;
import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.ReportForTheDay;
import com.shettar.exceptions.DaoException;
import com.shettar.servicesImpl.ReportServiceImpl;
import com.shettar.utilities.DateUtil;

/**
 * @author Pradeep.Shettar
 *
 */
public class ReportServiceTest {

	ReportServiceImpl reportServiceImpl;
	private CoffeeDao coffeeDao;

	@Before
	public void init() {
		reportServiceImpl = new ReportServiceImpl();
		coffeeDao = Mockito.mock(CoffeeDao.class);
		reportServiceImpl.setCoffeeDao(coffeeDao);
	}

	@Test
	public void testGetSuccessfulReport() {
		List<CoffeeForTheDay> listOfCoffees = new ArrayList<>();

		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		CoffeeForTheDayBuilder coffeeForTheDayBuilderTwo = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayTwo = coffeeForTheDayBuilderTwo.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderTwo.new CoffeeBuilder().initialise().populateCoffeeName("Caffè Americano")
				.populateCost(new Double(40))
				.populateDescription("Simply by adding hot water to a shot of espresso coffee");

		listOfCoffees.add(coffeeForTheDayTwo);

		CoffeeForTheDayBuilder coffeeForTheDayBuilderThree = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayThree = coffeeForTheDayBuilderThree.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderThree.new CoffeeBuilder().initialise().populateCoffeeName("Cappuccino")
				.populateCost(new Double(50)).populateDescription(
						"Composed of double espresso and hot milk, with the surface topped with foamed milk");

		listOfCoffees.add(coffeeForTheDayThree);

		CoffeeForTheDayBuilder coffeeForTheDayBuilderFour = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayFour = coffeeForTheDayBuilderFour.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderFour.new CoffeeBuilder().initialise().populateCoffeeName("Strong Coffee")
				.populateCost(new Double(20)).populateDescription("Simple coffee");

		listOfCoffees.add(coffeeForTheDayFour);

		try {
			Mockito.when(coffeeDao.getAllCoffeeForTheDay(Mockito.any(Date.class))).thenReturn(listOfCoffees);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		ReportForTheDay report = reportServiceImpl
				.getReport(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'hh:mm:ss"));

		Assert.assertEquals(CoffeeStallConstants.SUCCESS_STATUS_CODE, report.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.REPORT_SUCCESSFULLY_RETRIEVED, report.getStatusMessage());
		Assert.assertTrue(report.getCoffeesForTheDay().containsAll(listOfCoffees));
	}

	@Test
	public void testGetSuccessfulReportForSameDay() {
		List<CoffeeForTheDay> listOfCoffees = new ArrayList<>();

		// CoffeeForTheDay instance.
		CoffeeForTheDayBuilder coffeeForTheDayBuilder = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDay = coffeeForTheDayBuilder.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilder.new CoffeeBuilder().initialise().populateCoffeeName("Espresso")
				.populateCost(new Double(100)).populateDescription(
						"Shoot boiling water under high pressure through finely ground up coffee beans and then pour into a tiny mug");

		listOfCoffees.add(coffeeForTheDay);

		CoffeeForTheDayBuilder coffeeForTheDayBuilderTwo = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayTwo = coffeeForTheDayBuilderTwo.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderTwo.new CoffeeBuilder().initialise().populateCoffeeName("Caffè Americano")
				.populateCost(new Double(40))
				.populateDescription("Simply by adding hot water to a shot of espresso coffee");

		listOfCoffees.add(coffeeForTheDayTwo);

		CoffeeForTheDayBuilder coffeeForTheDayBuilderThree = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayThree = coffeeForTheDayBuilderThree.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderThree.new CoffeeBuilder().initialise().populateCoffeeName("Cappuccino")
				.populateCost(new Double(50)).populateDescription(
						"Composed of double espresso and hot milk, with the surface topped with foamed milk");

		listOfCoffees.add(coffeeForTheDayThree);

		CoffeeForTheDayBuilder coffeeForTheDayBuilderFour = new CoffeeForTheDayBuilder();
		CoffeeForTheDay coffeeForTheDayFour = coffeeForTheDayBuilderFour.initialise()
				.populateServingDate(DateUtil.constructDate("28-05-2018T23:30:00", "dd-MM-yyyy'T'HH:mm:ss"))
				.populateServingsLeft(100).populateTotalServings(100).construct();
		coffeeForTheDayBuilderFour.new CoffeeBuilder().initialise().populateCoffeeName("Strong Coffee")
				.populateCost(new Double(20)).populateDescription("Simple coffee");

		listOfCoffees.add(coffeeForTheDayFour);

		try {
			Mockito.when(coffeeDao.getAllCoffeeForTheDay(Mockito.any(Date.class))).thenReturn(listOfCoffees);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		ReportForTheDay report = reportServiceImpl
				.getReport(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'hh:mm:ss"));

		Assert.assertEquals(CoffeeStallConstants.SUCCESS_STATUS_CODE, report.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.REPORT_SUCCESSFULLY_RETRIEVED, report.getStatusMessage());
		Assert.assertTrue(report.getCoffeesForTheDay().containsAll(listOfCoffees));

	}

	@Test
	public void testGetReportFail() {

		try {
			DaoException daoException = new DaoException(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
			Mockito.when(coffeeDao.getAllCoffeeForTheDay(Mockito.any(Date.class))).thenThrow(daoException);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		ReportForTheDay report = reportServiceImpl
				.getReport(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'hh:mm:ss"));

		Assert.assertEquals(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE, report.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.COFFEE_NOT_AVAILABLE_MESSAGE, report.getStatusMessage());
		Assert.assertNull(report.getCoffeesForTheDay());
	}
}
