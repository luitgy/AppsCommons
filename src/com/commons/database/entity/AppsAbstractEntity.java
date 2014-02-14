package com.commons.database.entity;

import java.util.ArrayList;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 22/08/2013
 */
public interface AppsAbstractEntity {

	public String getTable();

	public ArrayList<String> getColumns();

	public ArrayList<Object> getValues();

}
