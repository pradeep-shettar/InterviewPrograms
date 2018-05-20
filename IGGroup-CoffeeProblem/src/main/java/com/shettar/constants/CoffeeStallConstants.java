/**
 * 
 */
package com.shettar.constants;

/**
 * @author Pradeep.Shettar
 *
 *         Constants class for the coffee stall application.
 */
public class CoffeeStallConstants {

	/**
	 * User defined status code for internal server error
	 */
	public static final String INTERNAL_SERVER_ERROR_STATUS_CODE = "CS-500";

	/**
	 * Constant to hold internal server error.
	 */
	public static final String INTERNAL_SERVER_ERROR = "Internal Server error occurred";
	
	/**
	 * User defined status code for internal server error
	 */
	public static final String PRECONDITION_FAILURE_STATUS_CODE = "CS-412";
	
	/**
	 * User defined status code for internal server error
	 */
	public static final String PRECONDITION_FAILURE_MESSAGE = "The resource already exists!";
	
	/**
	 * User defined error code for DB transaction failure.
	 */
	public static final String DATABASE_TRANSACTION_FAILURE_CODE = "DB-001";
	
	/**
	 * User defined error message for DB transaction failure.
	 */
	public static final String DATABASE_TRANSACTION_FAILURE = "Error while storing data!";

	/**
	 * User defined error code for DB while trying to create a customer who
	 * already exists.
	 */
	public static final String CREATING_DUPLICATE_CUSTOMER = "DB-002";
	
	/**
	 * User defined error message for DB transaction failure.
	 */
	public static final String CREATING_DUPLICATE_CUSTOMER_CODE = "Customer data already exists!";

	/**
	 * User defined error code for coffee entry already existing.
	 */
	public static final String CREATING_DUPLICATE_COFFEE_ENTRY_CODE = "DB-003";

	/**
	 * User defined error message for adding duplicate coffee entry.
	 */
	public static final String CREATING_DUPLICATE_COFFEE_ENTRY = "Coffee entry already exists!";

	/**
	 * User defined constant for data not found in Database.
	 */
	public static final String COFFEE_DATA_NOT_FOUND_CODE = "DB-004";

}