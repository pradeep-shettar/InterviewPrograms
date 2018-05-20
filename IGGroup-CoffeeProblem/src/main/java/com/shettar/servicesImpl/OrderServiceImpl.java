/**
 * 
 */
package com.shettar.servicesImpl;

import java.util.List;

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
import com.shettar.services.OrderService;

/**
 * @author Pradeep.Shettar
 *
 */
public class OrderServiceImpl implements OrderService {

	CustomerDao customerDao;
	
	CoffeeDao coffeeDao;
	
	/* (non-Javadoc)
	 * @see com.shettar.services.OrderService#processOrder(com.shettar.entities.OrderRequest)
	 */
	@Override
	public OrderResponse processOrder(OrderRequest orderRequest) throws ServiceException {
		OrderResponse orderResponse = new OrderResponse();
		List<CoffeeForTheDay> allCoffeeForTheDay = null;
		try {
			allCoffeeForTheDay = coffeeDao.getAllCoffeeForTheDay(orderRequest.getDate());
		} catch (DaoException daoException) {
			daoException.printStackTrace();
		}
		List<CoffeeOrder> coffees = orderRequest.getCoffees();
		for (CoffeeOrder coffeeOrder : coffees) {
			CoffeeForTheDay coffeeForTheDay = null;
			try {
				coffeeForTheDay = coffeeDao.getCoffeeForTheDay(coffeeOrder.getCoffee().getCoffeeName(), orderRequest.getDate());
			} catch (DaoException daoException) {
				throw new ServiceException(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
			}
		}
		Customer customer = orderRequest.getCustomer();
		
		return null;
	}

}
