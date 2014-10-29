package com.commons.exception;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
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
