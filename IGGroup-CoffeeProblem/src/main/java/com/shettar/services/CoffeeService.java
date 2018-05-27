/**
 * 
 */
package com.shettar.services;

import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeResponse;
import com.shettar.exceptions.ServiceException;

/**
 * @author Pradeep.Shettar
 *
 *         Interface for all coffee services.
 */
public interface CoffeeService {

	/**
	 * The method for creating a coffee for the day entry.
	 * 
	 * @param coffeeForTheDay
	 * @return
	 * @throws ServiceException 
	 */
	public CoffeeResponse addCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay);
}
