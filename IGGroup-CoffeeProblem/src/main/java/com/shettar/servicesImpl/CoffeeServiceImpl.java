/**
 * 
 */
package com.shettar.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shettar.constants.CoffeeStallConstants;
import com.shettar.dao.CoffeeDao;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeResponse;
import com.shettar.exceptions.DaoException;
import com.shettar.helpers.CoffeeServiceHelper;
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
	Logger logger = LoggerFactory.getLogger(CoffeeServiceImpl.class);

	/**
	 * The default constructor for Coffee Service.
	 */
	public CoffeeServiceImpl() {
	}

	@Autowired
	CoffeeDao coffeeDao;
	
	/**
	 * @return the coffeeDao
	 */
	public CoffeeDao getCoffeeDao() {
		return coffeeDao;
	}



	/**
	 * @param coffeeDao the coffeeDao to set
	 */
	public void setCoffeeDao(CoffeeDao coffeeDao) {
		this.coffeeDao = coffeeDao;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shettar.services.CoffeeService#addCoffeeForTheDay(com.shettar.
	 * entities.CoffeeForTheDay)
	 */
	@Override
	public CoffeeResponse addCoffeeForTheDay(CoffeeForTheDay coffeeForTheDay) {
		logger.debug("Entered addCoffeeForTheDay method of CoffeeServiceImpl class with parameter: "
				+ coffeeForTheDay.toString());
		CoffeeResponse coffeeResponse = new CoffeeResponse();
		try {
			coffeeDao.loadCoffeeForTheDay(coffeeForTheDay);
		} catch (DaoException daoException) {
			logger.error("DaoException caught in addCoffeeForTheDay method of CoffeeServiceImpl class: "
					+ daoException.toString());
			coffeeResponse = CoffeeServiceHelper.constructCoffeeResponseForException(daoException.getMessage(),coffeeForTheDay);
			return coffeeResponse;
		}
		coffeeResponse.setStatusCode(CoffeeStallConstants.CREATED_STATUS_CODE);
		coffeeResponse.setStatusMessage(CoffeeStallConstants.CREATED_COFFEE_MESSAGE);
		logger.debug("Exiting addCoffeeForTheDay method of CoffeeServiceImpl class with response: "
				+ coffeeResponse.toString());
		return coffeeResponse;
	}

}
