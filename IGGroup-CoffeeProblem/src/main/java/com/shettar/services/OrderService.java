/**
 * 
 */
package com.shettar.services;

import com.shettar.entities.OrderRequest;
import com.shettar.entities.OrderResponse;
import com.shettar.exceptions.ServiceException;

/**
 * @author Pradeep.Shettar
 *
 *	Interface for order services.
 */
public interface OrderService {

	/**
	 * The method to process the order.
	 * @throws ServiceException 
	 */
	public OrderResponse processOrder(OrderRequest orderRequest) throws ServiceException;
}
