/**
 * 
 */
package com.shettar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shettar.entities.OrderRequest;
import com.shettar.entities.OrderResponse;
import com.shettar.exceptions.ServiceException;
import com.shettar.helpers.OrderServiceHelper;
import com.shettar.services.OrderService;

/**
 * @author Pradeep.Shettar
 *
 *	The controller class for orders.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	/**
	 * @return the orderService
	 */
	public OrderService getOrderService() {
		return orderService;
	}

	/**
	 * @param orderService the orderService to set
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * Logger for class level logging
	 */
	Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OrderResponse makeAnOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse orderResponse = null;
		try {
			orderResponse = orderService.processOrder(orderRequest);
		} catch (ServiceException serviceException) {
			orderResponse = OrderServiceHelper.handleErrors(serviceException);
		}
		return orderResponse;
	}
}
