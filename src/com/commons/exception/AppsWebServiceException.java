package com.commons.exception;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 20/08/2013
 */
public class AppsWebServiceException extends AppsException {

	public AppsWebServiceException() {
		super();
	}

	public AppsWebServiceException(String message) {
		super(message);
	}

	public AppsWebServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppsWebServiceException(Throwable cause) {
		super(cause);
	}

	public AppsWebServiceException(Exception exception) {
		super(exception);
	}

	public AppsWebServiceException(String message, Exception exception) {
		super(message, exception);
	}

}
