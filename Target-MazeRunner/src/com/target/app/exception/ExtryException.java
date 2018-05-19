/**
 * 
 */
package com.target.app.exception;

/**
 * @author Pradeep.Shettar
 *
 */
public class ExtryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ExtryException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ExtryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ExtryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ExtryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ExtryException(Throwable cause) {
		super(cause);
	}

}
