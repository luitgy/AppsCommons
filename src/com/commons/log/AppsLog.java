package com.commons.log;

import android.util.Log;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 20/08/2013
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
