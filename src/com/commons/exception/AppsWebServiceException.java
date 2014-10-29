package com.commons.exception;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
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
