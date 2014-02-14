package com.commons.util;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 21/08/2013
 */
public class AppsComboEntity {

	private String key;
	private String value;

	public AppsComboEntity(String key, String value) {
		this.key = key;
		this.value = value;
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

	@Override
	public String toString() {
		return getValue();
	}
	
}
