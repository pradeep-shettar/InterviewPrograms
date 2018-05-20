/**
 * 
 */
package com.shettar.dao;

import java.util.Date;

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
	
	/**
	 * The method to get the CoffeeForTheDay value with coffee and date as parameter.
	 * 
	 * @param coffeeName
	 * @param date
	 * @return
	 * @throws DaoException
	 */
	public CoffeeForTheDay getCoffeeForTheDay(String coffeeName, Date date) throws DaoException;
	
	/**
	 * The method to update the coffee entry for the day.
	 * 
	 * @param coffeeForTheDay
	 * @throws DaoException
	 */
	public void updateCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay) throws DaoException;
	
	/**
	 * The method to remove the coffee for the day entry from the stored data.
	 * 
	 * @param coffeeName
	 * @param date
	 * @return
	 * @throws DaoException
	 */
	public CoffeeForTheDay removeCoffeeForTheDay(String coffeeName, Date date) throws DaoException;
}
