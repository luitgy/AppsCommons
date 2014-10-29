package com.commons.activity;

import com.actionbarsherlock.app.SherlockActivity;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public abstract class AppsAbstractActivity extends SherlockActivity {

	/**
	 * Empty Constructor
	 */
	public AppsAbstractActivity() {
	}
 
	/**
	 * Init Controls
	 */
	protected abstract void initControls();

	/**
	 * Init Actions (OnClickListenr, OnSelectListenr ...)
	 */
	protected abstract void initAction();

	/**
	 * Init Values
	 */
	protected abstract void initValues();

}
