/**
 * 
 */
package com.shettar.exceptions;

/**
 * @author Pradeep.Shettar
 *
 *         Exception class for Data object access transactions.
 */
public class DaoException extends Exception {

	/**
	 * Serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for DaoException.
	 */
	public DaoException() {
	}

	/**
	 * Constructor with message as parameter.
	 * 
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * Constructor with throwable as parameter.
	 * 
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
