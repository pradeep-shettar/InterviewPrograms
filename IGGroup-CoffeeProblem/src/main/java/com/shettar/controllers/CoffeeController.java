/**
 * 
 */
package com.shettar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.CoffeeResponse;
import com.shettar.exceptions.ServiceException;
import com.shettar.helpers.CoffeeServiceHelper;
import com.shettar.services.CoffeeService;

/**
 * @author Pradeep.Shettar
 * 
 *         The controller class for the Coffee service.
 *
 */
@RestController
@RequestMapping("/coffees")
public class CoffeeController {

	/**
	 * Logger for class level logging.
	 */
	Logger LOGGER = LoggerFactory.getLogger(CoffeeController.class);
	
	@Autowired
	CoffeeService coffeeService;
	
	/**
	 * @return the coffeeService
	 */
	public CoffeeService getCoffeeService() {
		return coffeeService;
	}


	/**
	 * @param coffeeService the coffeeService to set
	 */
	public void setCoffeeService(CoffeeService coffeeService) {
		this.coffeeService = coffeeService;
	}


	/**
	 * The method to create a coffee for the day entry.
	 * 
	 * @param coffeeForTheDay
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CoffeeResponse addCoffeeForTheDay(@RequestBody CoffeeForTheDay coffeeForTheDay) {
		CoffeeResponse coffeeResponse = null;
		try {
			coffeeResponse = coffeeService.addCoffeeForTheDay(coffeeForTheDay);
		} catch (ServiceException serviceException) {
			coffeeResponse = CoffeeServiceHelper.constructCoffeeResponseForException(serviceException,coffeeForTheDay);
		}
		return coffeeResponse;
	}
}
