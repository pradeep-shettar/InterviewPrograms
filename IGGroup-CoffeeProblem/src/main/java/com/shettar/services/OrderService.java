/**
 * 
 */
package com.shettar.services;

import com.shettar.entities.OrderRequest;
import com.shettar.entities.OrderResponse;

/**
 * @author Pradeep.Shettar
 *
 *	Interface for order services.
 */
public interface OrderService {

	/**
	 * The method to process the order.
	 */
	public OrderResponse processOrder(OrderRequest orderRequest);
}
