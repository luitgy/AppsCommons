package com.commons.exception;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 20/08/2013
 */
public class AppsDataBaseException extends AppsException {

	public AppsDataBaseException() {
		super();
	}

	public AppsDataBaseException(String message) {
		super(message);
	}

	public AppsDataBaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppsDataBaseException(Throwable cause) {
		super(cause);
	}

	public AppsDataBaseException(Exception exception) {
		super(exception);
	}

	public AppsDataBaseException(String message, Exception exception) {
		super(message, exception);
	}

}
