package com.commons.properties;

import java.util.ArrayList;
import java.util.HashMap;

import com.commons.database.AppsDataBaseController;
import com.commons.database.AppsQuery;
import com.commons.database.entity.AppsUpdate;
import com.commons.database.entity.AppsWhere;
import com.commons.exception.AppsDataBaseException;
import com.commons.properties.entity.AppsProperty;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 24/08/2013
 */
public class AppsProperties {

	private static HashMap<String, AppsProperty> properties = new HashMap<String, AppsProperty>();

	private static boolean inicializet = Boolean.FALSE;

	public static void putProperty(String key, AppsProperty value) {
		properties.put(key, value);
	}

	public static AppsProperty getValue(String key) {
		return properties.get(key);
	}

	public static boolean isInicializet() {
		return inicializet;
	}

	public static void setInicializet(boolean inicializet) {
		AppsProperties.inicializet = inicializet;
	}

	public static void updatePropertyOnDatabase(String key,
			AppsDataBaseController dbController) throws AppsDataBaseException {

		AppsProperty prop = AppsProperties.getValue(key);

		AppsQuery updateProp = new AppsQuery(AppsProperty.TABLE_NAME);

		ArrayList<AppsWhere> params = new ArrayList<AppsWhere>();
		params.add(new AppsWhere(AppsProperty.COLUMN_KEY,
				AppsWhere.OPERATION_EQUAL, key));

		ArrayList<AppsUpdate> valuesUpdate = new ArrayList<AppsUpdate>();
		valuesUpdate.add(new AppsUpdate(AppsProperty.COLUMN_VALUE, prop
				.getValue()));

		dbController.updateSQL(updateProp.createUpdate(params, valuesUpdate));

	}

}
