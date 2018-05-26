/**
 * 
 */
package com.shettar.helpers;

import java.util.Date;
import java.util.List;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeOrder;
import com.shettar.entities.Customer;
import com.shettar.entities.OrderResponse;
import com.shettar.entities.Receipt;
import com.shettar.exceptions.ServiceException;

/**
 * @author Pradeep.Shettar
 *
 */
public class OrderServiceHelper {

	/**
	 * @param serviceException
	 * @return 
	 */
	public static OrderResponse handleErrors(ServiceException serviceException) {
		OrderResponse orderResponse = new OrderResponse();
		if (serviceException.getMessage().equals(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE)) {
			orderResponse.setStatusCode(CoffeeStallConstants.DATA_NOT_FOUND_CODE);
			orderResponse.setStatusMessage(CoffeeStallConstants.COFFEE_NOT_AVAILABLE_MESSAGE);
		}
		else if (serviceException.getMessage().equals(CoffeeStallConstants.COFFEE_SOLD_OUT_CODE)) {
			orderResponse.setStatusCode(CoffeeStallConstants.DATA_NOT_FOUND_CODE);
			orderResponse.setStatusMessage(CoffeeStallConstants.COFFEE_NOT_AVAILABLE_MESSAGE);
		}
		return orderResponse;
	}

	/**
	 * @param customer 
	 * @param totalCost
	 * @param coffeeOrder 
	 * @param receiptNumber 
	 * @return
	 */
	public static Receipt constructReceipt(Customer customer, Double totalCost, List<CoffeeOrder> coffees, String receiptNumber) {
		Receipt receipt = new Receipt();
		receipt.setCoffeeOrders(coffees);
		receipt.setReceiptNumber(receiptNumber);
		receipt.setTotalCost(totalCost);
		receipt.setCustomer(customer);
		receipt.setReceiptDate(new Date());
		return receipt;
	}

	/**
	 * @param allCoffeeForTheDay
	 * @param coffeeName
	 * @return
	 */
	public static CoffeeForTheDay getCoffeeForTheDay(List<CoffeeForTheDay> allCoffeeForTheDay, String coffeeName) {
		for (CoffeeForTheDay coffeeForTheDay : allCoffeeForTheDay) {
			if (coffeeName.equals(coffeeForTheDay.getCoffee().getCoffeeName())) {
				return coffeeForTheDay;
			}
		}
		return null;
	}

}
