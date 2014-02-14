package com.commons.database.entity;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 23/08/2013
 */
public class AppsUpdate {

	public static String EQUAL = "=";

	private String column;
	private Object value;

	public AppsUpdate(String column, Object value) {
		this.column = column;
		this.value = value;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
