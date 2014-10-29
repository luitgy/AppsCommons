package com.commons.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public abstract class AppsValidator {

	private static String REG_EXP_EMAIL = "^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$";

	/**
	 * Empty Constructor
	 */
	private AppsValidator() {
	}

	public static boolean valdiateEmail(String email) {

		boolean valid = Boolean.TRUE;

		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern.compile(REG_EXP_EMAIL);
		mat = pat.matcher(email);

		if (!mat.find()) {
			valid = Boolean.FALSE;
		}

		return valid;

	}

}
