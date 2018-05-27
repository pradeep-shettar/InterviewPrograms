/**
 * 
 */
package com.shettar.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.exceptions.DaoException;

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

	/**
	 * @return the listOfCoffees
	 */
	public List<CoffeeForTheDay> getListOfCoffees() {
		return listOfCoffees;
	}

	/**
	 * @param listOfCoffees the listOfCoffees to set
	 */
	public void setListOfCoffees(List<CoffeeForTheDay> listOfCoffees) {
		this.listOfCoffees = listOfCoffees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shettar.dao.CoffeeDao#createCoffeeForTheDay(com.shettar.entities.
	 * CoffeeForTheDay)
	 */
	@Override
	public void loadCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay) throws DaoException {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.dao.CoffeeDao#getCoffeeForTheDay(java.lang.String,
	 * java.util.Date)
	 */
	@Override
	public CoffeeForTheDay getCoffeeForTheDay(String coffeeName, Date date) throws DaoException {
		LOGGER.debug("Entered the getCoffeeForTheDay method of CoffeeDaoImpl class with parameters CoffeeName: "
				+ coffeeName + " and Date: " + date);
		for (CoffeeForTheDay coffeeForTheDay : listOfCoffees) {
			if (coffeeName.equals(coffeeForTheDay.getCoffee().getCoffeeName())
					&& date.equals(coffeeForTheDay.getServingDate())) {
				if(coffeeForTheDay.getServingsLeft() == 0) {
					throw new DaoException(CoffeeStallConstants.COFFEE_SOLD_OUT_CODE);
				}
				LOGGER.debug(
						"Exiting the method getCoffeeForTheDay method of CoffeeDaoImpl class with coffeeForTheDay: "
								+ coffeeForTheDay.toString());
				return coffeeForTheDay;
			}
		}
		LOGGER.error(
				"Coffee for the day not found!. Exiting the method getCoffeeForTheDay method of CoffeeDaoImpl class ");
		throw new DaoException(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.shettar.dao.CoffeeDao#updateCoffeeForTheDay(com.shettar.entities.
	 * CoffeeForTheDay)
	 */
	@Override
	public void updateCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay) throws DaoException {
		LOGGER.debug("Entered the updateCoffeeForTheDay method of CoffeeDaoImpl class with parameter coffeeForTheDay: "
				+ coffeeForTheDay.toString());
		for (CoffeeForTheDay storedCoffeeForTheDay : listOfCoffees) {
			if (storedCoffeeForTheDay.getCoffee().equals(coffeeForTheDay.getCoffee())) {
				storedCoffeeForTheDay.setServingsLeft(coffeeForTheDay.getServingsLeft());
				LOGGER.debug("Exiting the updateCoffeeForTheDay method of CoffeeDaoImpl class ");
				return;
			}
		}
		LOGGER.error(
				"Coffee for the day not found! Exiting the method updateCoffeeForTheDay method of CoffeeDaoImpl class ");
		throw new DaoException(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.dao.CoffeeDao#removeCoffeeForTheDay(java.lang.String,
	 * java.util.Date)
	 */
	@Override
	public CoffeeForTheDay removeCoffeeForTheDay(String coffeeName, Date date) throws DaoException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.dao.CoffeeDao#getAllCoffeeForTheDay(java.util.Date)
	 */
	@Override
	public List<CoffeeForTheDay> getAllCoffeeForTheDay(Date date) throws DaoException {
		LOGGER.debug("Entered the method getAllCoffeeForTheDay method of CoffeeDaoImpl class with parameter date: "
				+ date.toString());
		if (listOfCoffees == null || listOfCoffees.isEmpty()) {
			throw new DaoException(CoffeeStallConstants.COFFEE_DATA_NOT_FOUND_CODE);
		}
		List<CoffeeForTheDay> coffeeForTheDayList = new ArrayList<>();
		for (CoffeeForTheDay coffeeForTheDay : listOfCoffees) {
			if (coffeeForTheDay.getServingDate().equals(date)) {
				coffeeForTheDayList.add(coffeeForTheDay);
			}
		}
		LOGGER.debug(
				"Exiting the method getAllCoffeeForTheDay method of CoffeeDaoImpl class with parameter coffeeForTheDayList: "
						+ coffeeForTheDayList.toString());
		return coffeeForTheDayList;
	}

}
