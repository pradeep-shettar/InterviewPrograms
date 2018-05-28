/**
 * 
 */
package com.shettar.servicesImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.dao.CustomerDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeOrder;
import com.shettar.entities.Customer;
import com.shettar.entities.OrderRequest;
import com.shettar.entities.OrderResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.helpers.OrderServiceHelper;
import com.shettar.services.OrderService;

/**
 * @author Pradeep.Shettar
 *
 */
public class OrderServiceImpl implements OrderService {

	/**
	 * Logger instance for class level logging.
	 */
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CoffeeDao coffeeDao;

	/**
	 * @return the customerDao
	 */
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	/**
	 * @param customerDao
	 *            the customerDao to set
	 */
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * @return the coffeeDao
	 */
	public CoffeeDao getCoffeeDao() {
		return coffeeDao;
	}

	/**
	 * @param coffeeDao
	 *            the coffeeDao to set
	 */
	public void setCoffeeDao(CoffeeDao coffeeDao) {
		this.coffeeDao = coffeeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.services.OrderService#processOrder(com.shettar.entities.
	 * OrderRequest)
	 */
	@Override
	public OrderResponse processOrder(OrderRequest orderRequest) {
		logger.debug("Entered processOrder method with orderRequest: " + orderRequest.toString());
		OrderResponse orderResponse = new OrderResponse();
		List<CoffeeForTheDay> allCoffeeForTheDay = null;
		Double totalCost = new Double(0);
		try {
			allCoffeeForTheDay = coffeeDao.getAllCoffeeForTheDay(orderRequest.getDate());
		} catch (DaoException daoException) {
			logger.error("DaoException caught in processOrder method: " + daoException.toString());
			orderResponse = OrderServiceHelper.handleErrors(daoException.getMessage());
			logger.debug("Exiting processOrder method with orderResponse: " + orderResponse.toString());
			return orderResponse;
		}
		if (allCoffeeForTheDay == null) {
			orderResponse = OrderServiceHelper.handleErrors(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
			logger.debug("Exiting processOrder method with orderResponse: " + orderResponse.toString());
			return orderResponse;
		}
		List<CoffeeOrder> coffees = orderRequest.getCoffees();
		for (CoffeeOrder coffeeOrder : coffees) {
			CoffeeForTheDay coffeeForTheDay = OrderServiceHelper.getCoffeeForTheDay(allCoffeeForTheDay,
					coffeeOrder.getCoffeeName());
			if (coffeeForTheDay == null) {
				orderResponse = OrderServiceHelper.handleErrors(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
				logger.debug("Exiting processOrder method with orderResponse: " + orderResponse.toString());
				return orderResponse;
			}
			coffeeForTheDay.decrementServings();
			totalCost = totalCost + (coffeeForTheDay.getCoffee().getCost() * coffeeOrder.getCount());
			try {
				coffeeDao.updateCoffeeForTheDay(coffeeForTheDay);
			} catch (DaoException daoException) {
				logger.error("DaoException caught in processOrder method: " + daoException.toString());
				orderResponse = OrderServiceHelper.handleErrors(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
				logger.debug("Exiting processOrder method with orderResponse: " + orderResponse.toString());
				return orderResponse;
			}
		}
		Customer customer = orderRequest.getCustomer();
		orderResponse.setReceipt(OrderServiceHelper.constructReceipt(customer, totalCost, coffees,
				String.valueOf(orderRequest.getDate().getTime())));
		orderResponse.setStatusCode(CoffeeStallConstants.SUCCESS_STATUS_CODE);
		orderResponse.setStatusMessage(CoffeeStallConstants.ORDER_PLACED_MESSAGE);
		logger.debug("Exiting processOrder method with orderResponse: " + orderResponse.toString());
		return orderResponse;
	}

}
