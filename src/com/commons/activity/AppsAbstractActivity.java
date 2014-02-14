package com.commons.activity;

import com.actionbarsherlock.app.SherlockActivity;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 20/08/2013
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
