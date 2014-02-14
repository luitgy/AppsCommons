package com.commons.exception;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 20/08/2013
 */
public class AppsException extends Exception {

	private Exception exception;

	public AppsException() {
		super();
	}

	public AppsException(String message) {
		super(message);
	}

	public AppsException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppsException(Throwable cause) {
		super(cause);
	}

	public AppsException(Exception exception) {
		this.exception = exception;
	}

	public AppsException(String message, Exception exception) {
		super(message);
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
