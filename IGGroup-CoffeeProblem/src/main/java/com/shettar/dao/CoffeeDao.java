/**
 * 
 */
package com.shettar.dao;

import com.shettar.entities.CoffeeForTheDay;
import com.shettar.exceptions.DaoException;

/**
 * @author Pradeep.Shettar
 * 
 *         The interface for Dao transaction of Coffee type.
 */
public interface CoffeeDao {

	/**
	 * The method to create and add coffee for the day data.
	 * 
	 * @param coffeeForTheDay
	 * @throws DaoException 
	 */
	public void createCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay) throws DaoException;
}
