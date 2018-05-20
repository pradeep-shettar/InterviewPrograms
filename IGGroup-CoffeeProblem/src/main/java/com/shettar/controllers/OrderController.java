/**
 * 
 */
package com.shettar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shettar.entities.CoffeeOrder;
import com.shettar.entities.OrderRequest;
import com.shettar.entities.OrderResponse;
import com.shettar.services.OrderService;

/**
 * @author Pradeep.Shettar
 *
 *	The controller class for orders.
 */
@RequestMapping("/order")
public class OrderController {

	OrderService orderService;
	/**
	 * Logger for class level logging
	 */
	Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OrderResponse makeAnOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse orderResponse = orderService.processOrder(orderRequest);
		return null;
	}
}
