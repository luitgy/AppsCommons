package com.commons.properties.entity;

import java.util.ArrayList;

import com.commons.database.entity.AppsAbstractEntity;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public class AppsProperty implements AppsAbstractEntity {

	public static String TABLE_NAME = "properties";

	public static String COLUMN_KEY = "key";
	public static String COLUMN_VALUE = "value";

	public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
			+ COLUMN_KEY + " VARCHAR(50), " + COLUMN_VALUE + " VARCHAR(50))";

	public String key;
	public String value;

	/**
	 * Empty Constructor
	 */
	public AppsProperty() {
	}

	public AppsProperty(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTable() {
		return TABLE_NAME;
	}

	@Override
	public ArrayList<String> getColumns() {

		ArrayList<String> columns = new ArrayList<String>();
		columns.add(COLUMN_KEY);
		columns.add(COLUMN_VALUE);

		return columns;

	}

	@Override
	public ArrayList<Object> getValues() {
		
		ArrayList<Object> values = new ArrayList<Object>();
		
		values.add(getKey());
		values.add(getValue());
		
		return values;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
