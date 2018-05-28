/**
 * 
 */
package com.shettar.builders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shettar.entities.CoffeeOrder;
import com.shettar.entities.Customer;
import com.shettar.entities.OrderRequest;

/**
 * @author Pradeep.Shettar
 *
 */
public class OrderRequestBuilder {

	OrderRequest orderRequest;

	public OrderRequestBuilder initialise() {
		orderRequest = new OrderRequest();
		return this;
	}

	public OrderRequestBuilder populateDate(Date date) {
		orderRequest.setDate(date);
		return this;
	}

	public OrderRequestBuilder populateCustomer(Customer customer) {
		orderRequest.setCustomer(customer);
		return this;
	}

	public OrderRequest construct() {
		return orderRequest;
	}

	public class CoffeeOrderBuilder {

		CoffeeOrder coffeeOrder;

		public CoffeeOrderBuilder initialise() {
			coffeeOrder = new CoffeeOrder();
			if (orderRequest.getCoffees() == null) {
				orderRequest.setCoffees(new ArrayList<>());
			}
			List<CoffeeOrder> coffees = orderRequest.getCoffees();
			coffees.add(coffeeOrder);
			return this;
		}

		public CoffeeOrderBuilder populateCoffeeName(String coffeeName) {
			coffeeOrder.setCoffeeName(coffeeName);
			return this;
		}

		public CoffeeOrderBuilder populateCount(Integer count) {
			coffeeOrder.setCount(count);
			return this;
		}
	}
}
