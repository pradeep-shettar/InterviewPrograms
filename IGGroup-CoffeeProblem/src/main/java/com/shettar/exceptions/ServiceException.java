/**
 * 
 */
package com.shettar.exceptions;

/**
 * @author Pradeep.Shettar
 * 
 *         Exception class for service.
 */
public class ServiceException extends Exception {

	/**
	 * Serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for Service Exception class.
	 */
	public ServiceException() {
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
