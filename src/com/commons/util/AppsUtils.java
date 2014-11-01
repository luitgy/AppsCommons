package com.commons.util;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public abstract class AppsUtils {

	/**
	 * Empty Constructor
	 */
	private AppsUtils() {
	}
	
	public static String numberFormat(Float number, int fractionDigit) {

		String numberFormat = AppsConstants.EMPTY_STRING;

		if (number != null) {

			NumberFormat format = NumberFormat.getNumberInstance();
			format.setMaximumFractionDigits(fractionDigit);
			format.setMinimumFractionDigits(fractionDigit);
			
			numberFormat = format.format(number);

		}

		return numberFormat;

	}
	
	public static String numberFormat(Double number, int fractionDigit) {

		String numberFormat = AppsConstants.EMPTY_STRING;

		if (number != null) {

			NumberFormat format = NumberFormat.getNumberInstance();
			format.setMaximumFractionDigits(fractionDigit);
			format.setMinimumFractionDigits(fractionDigit);

			numberFormat = format.format(number);

		}

		return numberFormat;

	}

	public static String numberFormat(Long number, int fractionDigit) {

		String numberFormat = AppsConstants.EMPTY_STRING;

		if (number != null) {

			NumberFormat format = NumberFormat.getNumberInstance();
			format.setMaximumFractionDigits(fractionDigit);
			format.setMinimumFractionDigits(fractionDigit);

			numberFormat = format.format(number);

		}

		return numberFormat;

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
