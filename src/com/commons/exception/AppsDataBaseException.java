package com.commons.exception;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
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
