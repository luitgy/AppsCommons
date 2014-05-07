package com.commons.util;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 20/08/2013
 */
public abstract class AppsUtils {

	/**
	 * Empty Constructor
	 */
	private AppsUtils() {
	}

	public static boolean isConnexionEnabled(Context context) {

		boolean enabled = Boolean.FALSE;

		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo netInfo = cm.getActiveNetworkInfo();

		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			enabled = Boolean.TRUE;
		}

		return enabled;

	}

	public static boolean isEmpty(Cursor cursor) {
		return (cursor == null || (!cursor.moveToFirst()));
	}

	public static boolean isEmpty(HashMap parameters) {
		return (parameters == null || (parameters.isEmpty()));
	}

	public static boolean isEmpty(List list) {
		return (list == null || (list.isEmpty()));
	}

	public static boolean isEmpty(String s) {
		return (s == null || (s.trim().equals(AppsConstants.EMPTY_STRING)));
	}

}
