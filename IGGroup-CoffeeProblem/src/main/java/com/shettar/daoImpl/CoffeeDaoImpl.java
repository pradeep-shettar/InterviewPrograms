/**
 * 
 */
package com.shettar.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.exceptions.DaoException;
import com.shettar.exceptions.ServiceException;

/**
 * @author Pradeep.Shettar
 *
 *         The implementation class for the Dao class of Coffee operation.
 */
public class CoffeeDaoImpl implements CoffeeDao {

	/**
	 * Logger for class level logging.
	 */
	private Logger LOGGER = LoggerFactory.getLogger(CoffeeDaoImpl.class);

	private List<CoffeeForTheDay> listOfCoffees;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shettar.dao.CoffeeDao#createCoffeeForTheDay(com.shettar.entities.
	 * CoffeeForTheDay)
	 */
	@Override
	public void createCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay) throws DaoException {
		LOGGER.debug("Entered the createCoffeeForTheDay method of CoffeeDaoImpl class with parameter: "
				+ coffeeForTheDay.toString());
		if (listOfCoffees == null) {
			listOfCoffees = new ArrayList<>();
			listOfCoffees.add(coffeeForTheDay);
			LOGGER.debug(
					"Exiting the createCoffeeForTheDay method of CoffeeDaoImpl class after adding the first entry!");
			return;
		} else if (listOfCoffees.contains(coffeeForTheDay)) {
			LOGGER.error("Exception caught due to making duplicate entry of coffee details.");
			throw new DaoException(CoffeeStallConstants.CREATING_DUPLICATE_COFFEE_ENTRY_CODE);
		} else {
			listOfCoffees.add(coffeeForTheDay);
			LOGGER.debug("Exiting the createCoffeeForTheDay method of CoffeeDaoImpl class");
		}
	}

}
