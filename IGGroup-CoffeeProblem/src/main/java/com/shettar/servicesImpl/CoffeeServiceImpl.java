/**
 * 
 */
package com.shettar.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.exceptions.ServiceException;
import com.shettar.services.CoffeeService;

/**
 * @author Pradeep.Shettar
 * 
 *         Implementation class for the coffee service.
 */
public class CoffeeServiceImpl implements CoffeeService {

	/**
	 * The Logger for class level logging.
	 */
	Logger LOGGER = LoggerFactory.getLogger(CoffeeServiceImpl.class);

	/**
	 * The default constructor for Coffee Service.
	 */
	public CoffeeServiceImpl() {
	}

	CoffeeDao coffeeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.services.CoffeeService#addCoffeeForTheDay(com.shettar.
	 * entities.CoffeeForTheDay)
	 */
	@Override
	public CoffeeResponse addCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay) throws ServiceException {
		LOGGER.debug("Entered addCoffeeForTheDay method of CoffeeServiceImpl class with parameter: "
				+ coffeeForTheDay.toString());
		CoffeeResponse coffeeResponse = new CoffeeResponse();
		try {
			coffeeDao.createCoffeeForTheDay(coffeeForTheDay);
		} catch (DaoException daoException) {
			LOGGER.error("DaoException caught in addCoffeeForTheDay method of CoffeeServiceImpl class: "
					+ daoException.toString());
			throw new ServiceException(daoException.getMessage());
		}
		LOGGER.debug("Exiting addCoffeeForTheDay method of CoffeeServiceImpl class with response: "
				+ coffeeResponse.toString());
		return coffeeResponse;
	}

}
