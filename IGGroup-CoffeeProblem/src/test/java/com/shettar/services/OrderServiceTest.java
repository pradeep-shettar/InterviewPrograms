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
import com.shettar.builders.CustomerBuilder;
import com.shettar.builders.OrderRequestBuilder;
import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.dao.CustomerDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.Customer;
import com.shettar.entities.OrderRequest;
import com.shettar.entities.OrderResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.servicesImpl.OrderServiceImpl;
import com.shettar.utilities.DateUtil;

/**
 * @author Pradeep.Shettar
 *
 */
public class OrderServiceTest {

	OrderServiceImpl orderServiceImpl;
	private CoffeeDao coffeeDao;
	private CustomerDao customerDao;

	@Before
	public void init() {
		orderServiceImpl = new OrderServiceImpl();
		coffeeDao = Mockito.mock(CoffeeDao.class);
		orderServiceImpl.setCoffeeDao(coffeeDao);
		customerDao = Mockito.mock(CustomerDao.class);
		orderServiceImpl.setCustomerDao(customerDao);
	}

	@Test
	public void testProcessDataForSuccessfulOrder() {
		OrderRequestBuilder orderRequestBuilder = new OrderRequestBuilder();

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

		// Customer details for the order.
		Customer customer = new CustomerBuilder().initialise().populateContactNumber("+919876543210")
				.populateName("Pradeep").construct();

		// Request for the order.
		OrderRequest orderRequest = orderRequestBuilder.initialise().populateCustomer(customer)
				.populateDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss")).construct();
		orderRequestBuilder.new CoffeeOrderBuilder().initialise().populateCoffeeName("Espresso").populateCount(2);
		orderRequestBuilder.new CoffeeOrderBuilder().initialise().populateCoffeeName("Cappuccino").populateCount(3);

		OrderResponse orderResponse = orderServiceImpl.processOrder(orderRequest);
		Assert.assertEquals(CoffeeStallConstants.SUCCESS_STATUS_CODE, orderResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.ORDER_PLACED_MESSAGE, orderResponse.getStatusMessage());
		Assert.assertNotNull(orderResponse.getReceipt());
		Assert.assertNotNull(orderResponse.getReceipt().getReceiptNumber());
		Assert.assertEquals(new Double(350), orderResponse.getReceipt().getTotalCost());
		Assert.assertEquals(orderRequest.getCoffees(), orderResponse.getReceipt().getCoffeeOrders());
		Assert.assertEquals(orderRequest.getCustomer(), orderResponse.getReceipt().getCustomer());
	}

	/**
	 * Test case for empty coffeeList
	 */
	@Test
	public void testProcessOrderForCoffeeListEmpty() {
		OrderRequestBuilder orderRequestBuilder = new OrderRequestBuilder();

		List<CoffeeForTheDay> listOfCoffees = new ArrayList<>();

		try {
			Mockito.when(coffeeDao.getAllCoffeeForTheDay(Mockito.any(Date.class))).thenReturn(listOfCoffees);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		// Customer details for the order.
		Customer customer = new CustomerBuilder().initialise().populateContactNumber("+919876543210")
				.populateName("Pradeep").construct();

		// Request for the order.
		OrderRequest orderRequest = orderRequestBuilder.initialise().populateCustomer(customer)
				.populateDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss")).construct();
		orderRequestBuilder.new CoffeeOrderBuilder().initialise().populateCoffeeName("Espresso").populateCount(2);
		orderRequestBuilder.new CoffeeOrderBuilder().initialise().populateCoffeeName("Cappuccino").populateCount(3);

		OrderResponse orderResponse = orderServiceImpl.processOrder(orderRequest);
		Assert.assertEquals(CoffeeStallConstants.DATA_NOT_FOUND_CODE, orderResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.COFFEE_NOT_AVAILABLE_MESSAGE, orderResponse.getStatusMessage());
	}

	/**
	 * Test case for empty coffeeList
	 */
	@Test
	public void testProcessOrderForCoffeeListNull() {
		OrderRequestBuilder orderRequestBuilder = new OrderRequestBuilder();

		List<CoffeeForTheDay> listOfCoffees = null;

		try {
			Mockito.when(coffeeDao.getAllCoffeeForTheDay(Mockito.any(Date.class))).thenReturn(listOfCoffees);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		// Customer details for the order.
		Customer customer = new CustomerBuilder().initialise().populateContactNumber("+919876543210")
				.populateName("Pradeep").construct();

		// Request for the order.
		OrderRequest orderRequest = orderRequestBuilder.initialise().populateCustomer(customer)
				.populateDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss")).construct();
		orderRequestBuilder.new CoffeeOrderBuilder().initialise().populateCoffeeName("Espresso").populateCount(2);
		orderRequestBuilder.new CoffeeOrderBuilder().initialise().populateCoffeeName("Cappuccino").populateCount(3);

		OrderResponse orderResponse = orderServiceImpl.processOrder(orderRequest);
		Assert.assertEquals(CoffeeStallConstants.DATA_NOT_FOUND_CODE, orderResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.COFFEE_NOT_AVAILABLE_MESSAGE, orderResponse.getStatusMessage());
	}

	/**
	 * Test case for empty coffeeList
	 */
	@Test
	public void testProcessOrderDaoException() {
		OrderRequestBuilder orderRequestBuilder = new OrderRequestBuilder();

		try {
			DaoException daoException = new DaoException(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
			Mockito.when(coffeeDao.getAllCoffeeForTheDay(Mockito.any(Date.class))).thenThrow(daoException);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		// Customer details for the order.
		Customer customer = new CustomerBuilder().initialise().populateContactNumber("+919876543210")
				.populateName("Pradeep").construct();

		// Request for the order.
		OrderRequest orderRequest = orderRequestBuilder.initialise().populateCustomer(customer)
				.populateDate(DateUtil.constructDate("28-05-2018T01:30:00", "dd-MM-yyyy'T'HH:mm:ss")).construct();
		orderRequestBuilder.new CoffeeOrderBuilder().initialise().populateCoffeeName("Espresso").populateCount(2);
		orderRequestBuilder.new CoffeeOrderBuilder().initialise().populateCoffeeName("Cappuccino").populateCount(3);

		OrderResponse orderResponse = orderServiceImpl.processOrder(orderRequest);
		Assert.assertEquals(CoffeeStallConstants.DATA_NOT_FOUND_CODE, orderResponse.getStatusCode());
		Assert.assertEquals(CoffeeStallConstants.COFFEE_NOT_AVAILABLE_MESSAGE, orderResponse.getStatusMessage());
	}
}
