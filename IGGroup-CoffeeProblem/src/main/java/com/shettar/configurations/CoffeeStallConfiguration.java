/**
 * 
 */
package com.shettar.configurations;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shettar.dao.CoffeeDao;
import com.shettar.dao.CustomerDao;
import com.shettar.daoImpl.CoffeeDaoImpl;
import com.shettar.daoImpl.CustomerDaoImpl;
import com.shettar.entities.CoffeeForTheDay;
import com.shettar.entities.Customer;
import com.shettar.services.CoffeeService;
import com.shettar.services.CustomerService;
import com.shettar.services.OrderService;
import com.shettar.services.ReportService;
import com.shettar.servicesImpl.CoffeeServiceImpl;
import com.shettar.servicesImpl.CustomerServiceImpl;
import com.shettar.servicesImpl.OrderServiceImpl;
import com.shettar.servicesImpl.ReportServiceImpl;

/**
 * @author Pradeep.Shettar
 *
 */
@Configuration
public class CoffeeStallConfiguration {
	CustomerDaoImpl customerDao;
	CoffeeDaoImpl coffeeDao;

	@Bean
	public CoffeeService getCoffeeService() {
		CoffeeServiceImpl coffeeService = new CoffeeServiceImpl();
		coffeeService.setCoffeeDao(getCoffeeDao());
		return coffeeService;
	}

	@Bean
	public CoffeeDao getCoffeeDao() {
		if (coffeeDao == null) {
			coffeeDao = new CoffeeDaoImpl();
			coffeeDao.setListOfCoffees(new ArrayList<CoffeeForTheDay>());
		}
		return coffeeDao;
	}

	@Bean
	public CustomerService getCustomerService() {
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.setCustomerDao(getCustomerDao());
		return customerServiceImpl;
	}

	@Bean
	public CustomerDao getCustomerDao() {
		if (customerDao == null) {
			customerDao = new CustomerDaoImpl();
			customerDao.setCustomers(new ArrayList<Customer>());
		}
		return customerDao;
	}

	@Bean
	public OrderService getOrderService() {
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		orderServiceImpl.setCoffeeDao(getCoffeeDao());
		orderServiceImpl.setCustomerDao(getCustomerDao());
		return orderServiceImpl;
	}

	@Bean
	public ReportService getReportService() {
		ReportServiceImpl reportServiceImpl = new ReportServiceImpl();
		reportServiceImpl.setCoffeeDao(getCoffeeDao());
		return reportServiceImpl;
	}
}
