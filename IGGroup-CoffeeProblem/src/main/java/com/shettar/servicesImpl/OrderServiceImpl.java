/**
 * 
 */
package com.shettar.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
			daoException.printStackTrace();
		}
		List<CoffeeOrder> coffees = orderRequest.getCoffees();
		for (CoffeeOrder coffeeOrder : coffees) {
			CoffeeForTheDay coffeeForTheDay = null;
			try {
				coffeeForTheDay = coffeeDao.getCoffeeForTheDay(coffeeOrder.getCoffeeName(), orderRequest.getDate());
			} catch (DaoException daoException) {
				throw new ServiceException(daoException.getMessage());
			}
			coffeeForTheDay.decrementServings();
			totalCost = totalCost + coffeeForTheDay.getCoffee().getCost();
		}
		Customer customer = orderRequest.getCustomer();
		orderResponse.setReceipt(OrderServiceHelper.constructReceipt(totalCost, coffees,
				String.valueOf(orderRequest.getDate()).concat(String.valueOf(allCoffeeForTheDay.size()))));
		return orderResponse;
	}

}
