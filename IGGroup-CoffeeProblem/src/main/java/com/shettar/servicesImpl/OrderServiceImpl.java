/**
 * 
 */
package com.shettar.servicesImpl;

import java.util.List;

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
import com.shettar.exceptions.ServiceException;
import com.shettar.helpers.OrderServiceHelper;
import com.shettar.services.OrderService;

/**
 * @author Pradeep.Shettar
 *
 */
public class OrderServiceImpl implements OrderService {

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
	public OrderResponse processOrder(OrderRequest orderRequest) throws ServiceException {
		OrderResponse orderResponse = new OrderResponse();
		List<CoffeeForTheDay> allCoffeeForTheDay = null;
		Double totalCost = new Double(0);
		try {
			allCoffeeForTheDay = coffeeDao.getAllCoffeeForTheDay(orderRequest.getDate());
		} catch (DaoException daoException) {
			throw new ServiceException(daoException.getMessage());
		}
		List<CoffeeOrder> coffees = orderRequest.getCoffees();
		for (CoffeeOrder coffeeOrder : coffees) {
			CoffeeForTheDay coffeeForTheDay = OrderServiceHelper.getCoffeeForTheDay(allCoffeeForTheDay, coffeeOrder.getCoffeeName());
			if (coffeeForTheDay == null) {
				throw new ServiceException(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
			}
			coffeeForTheDay.decrementServings();
			totalCost = totalCost + (coffeeForTheDay.getCoffee().getCost()*coffeeOrder.getCount());
		}
		Customer customer = orderRequest.getCustomer();
		orderResponse.setReceipt(OrderServiceHelper.constructReceipt(customer, totalCost, coffees,
				String.valueOf(orderRequest.getDate().getTime())));
		orderResponse.setStatusCode(CoffeeStallConstants.SUCCESS_STATUS_CODE);
		orderResponse.setStatusMessage(CoffeeStallConstants.ORDER_PLACED_MESSAGE);
		return orderResponse;
	}

}
