package com.commons.util;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public abstract class AppsConstants {

	// GENERICS
	public static String EMPTY_STRING = "";
	public static String SPACE = " ";
	public static String FORMAT_DATE_DD_MM_YYYY = "dd/MM/yyyy";
	public static String YES = "Y";
	public static String NO = "N";
	public static Integer FIRST_ELEMENT_LIST = 0;

	// PROPERTIES
	public static String PROPERTY_APP_VERSION = "app_version";

	// LOG
	public static String LOG_DATABASE_TAG = "APPS_SQL";

	// VIEWS
	public static Integer VIEW_VISIBLE = 0;
	public static Integer VIEW_NO_VISIBLE = 100;

	private AppsConstants() {
	}

}
