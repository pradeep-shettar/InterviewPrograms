/**
 * 
 */
package com.shettar.servicesImpl;

import java.util.List;

import com.shettar.dao.CoffeeDao;
import com.shettar.dao.CustomerDao;
import com.shettar.entities.CoffeeOrder;
import com.shettar.entities.Customer;
import com.shettar.entities.OrderRequest;
import com.shettar.entities.OrderResponse;
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
	public OrderResponse processOrder(OrderRequest orderRequest) {
		OrderResponse orderResponse = new OrderResponse();
		
		List<CoffeeOrder> coffees = orderRequest.getCoffees();
		for (CoffeeOrder coffeeOrder : coffees) {
		}
		Customer customer = orderRequest.getCustomer();
		
		return null;
	}

}
