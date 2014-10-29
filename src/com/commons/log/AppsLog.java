package com.commons.log;

import android.util.Log;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public class AppsLog {

	public static void error(String logTag, String message) {
		Log.e(logTag, message);
	}

	public static void error(String logTag, String message, Throwable ex) {
		Log.e(logTag, message, ex);
	}

	public static void warning(String logTag, String message) {
		Log.e(logTag, message);
	}

	public static void warning(String logTag, String message, Throwable ex) {
		Log.e(logTag, message, ex);
	}

	public static void info(String logTag, String message) {
		Log.e(logTag, message);
	}

	public static void info(String logTag, String message, Throwable ex) {
		Log.e(logTag, message, ex);
	}

	public static void debug(String logTag, String message) {
		Log.e(logTag, message);
	}

	public static void debug(String logTag, String message, Throwable ex) {
		Log.e(logTag, message, ex);
	}

	public static void verbose(String logTag, String message) {
		Log.e(logTag, message);
	}

	public static void verbose(String logTag, String message, Throwable ex) {
		Log.e(logTag, message, ex);
	}

}
