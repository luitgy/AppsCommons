package com.commons.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.commons.database.entity.AppsAbstractEntity;
import com.commons.database.entity.AppsUpdate;
import com.commons.database.entity.AppsWhere;
import com.commons.exception.AppsDataBaseException;
import com.commons.log.AppsLog;
import com.commons.messages.AppsMessages;
import com.commons.util.AppsConstants;
import com.commons.util.AppsUtils;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public class AppsQuery {

	public static String SELECT = "SELECT";
	public static String FROM = "FROM";
	public static String WHERE = "WHERE";
	public static String DELETE = "DELETE FROM";
	public static String INSERT = "INSERT INTO";
	public static String VALUES = "VALUES";
	public static String UPDATE = "UPDATE";
	public static String SET = "SET";
	public static String ORDER_BY = "ORDER BY";

	private ArrayList<String> columnsSelect = new ArrayList<String>();
	private ArrayList<AppsWhere> parameters = new ArrayList<AppsWhere>();
	private ArrayList<String> orderBy = new ArrayList<String>();
	private String table;

	/**
	 * Empty Constructor
	 */
	public AppsQuery(String table) {
		this.table = table;
	}

	public String createUpdate(ArrayList<AppsWhere> params,
			ArrayList<AppsUpdate> valuesUpdate) throws AppsDataBaseException {

		if (AppsUtils.isEmpty(valuesUpdate)) {
			throw new AppsDataBaseException(
					AppsMessages.NOT_REPORTED_VALUE_UPDATE);
		}

		String strUpdateValues = createUpdateValues(valuesUpdate);

		String strParams = AppsConstants.EMPTY_STRING;

		if (!AppsUtils.isEmpty(params)) {
			strParams = createWhere(params);
		}

		String update = UPDATE + AppsConstants.SPACE + table
				+ AppsConstants.SPACE + SET + AppsConstants.SPACE
				+ strUpdateValues + AppsConstants.SPACE + strParams;

		AppsLog.debug(AppsConstants.LOG_DATABASE_TAG, update);

		return update;

	}

	private String createUpdateValues(ArrayList<AppsUpdate> valuesUpdate) {

		String strUpdateValues = AppsConstants.EMPTY_STRING;

		Iterator<AppsUpdate> iterUpdate = valuesUpdate.iterator();
		boolean firstUpdateValue = Boolean.TRUE;

		while (iterUpdate.hasNext()) {

			if (firstUpdateValue) {
				firstUpdateValue = Boolean.FALSE;
			} else {
				strUpdateValues += ",";
			}

			AppsUpdate valUpdate = iterUpdate.next();

			Object value = valUpdate.getValue();
			String strValue = AppsConstants.EMPTY_STRING;

			if (value instanceof String) {
				strValue += "'" + value.toString() + "'";
			} else if (value instanceof Integer) {
				strValue += ((Integer) value).intValue()
						+ AppsConstants.EMPTY_STRING;
			} else if (value instanceof Double) {
				strValue += ((Double) value).doubleValue()
						+ AppsConstants.EMPTY_STRING;
			} else if (value instanceof Long) {
				strValue += ((Long) value).longValue()
						+ AppsConstants.EMPTY_STRING;
			} else if (value instanceof Float) {
				strValue += ((Float) value).floatValue()
						+ AppsConstants.EMPTY_STRING;
			} else if (value instanceof Date) {

				String strDate = new SimpleDateFormat(
						AppsConstants.FORMAT_DATE_DD_MM_YYYY)
						.format((Date) value);

				strValue += "'" + strDate + "'";

			} else if (value == null) {
				strValue += "null";
			}

			strUpdateValues += valUpdate.getColumn() + AppsConstants.SPACE
					+ AppsUpdate.EQUAL + AppsConstants.SPACE + strValue;

		}

		return strUpdateValues;

	}

	public String createDelete(String tableDelete, ArrayList<AppsWhere> params) {

		String strParams = AppsConstants.EMPTY_STRING;

		if (!AppsUtils.isEmpty(params)) {
			strParams = createWhere(params);
		}

		String delete = DELETE + AppsConstants.SPACE + tableDelete
				+ AppsConstants.SPACE + strParams;

		AppsLog.debug(AppsConstants.LOG_DATABASE_TAG, delete);

		return delete;

	}

	public String createInsert(AppsAbstractEntity entity)
			throws AppsDataBaseException {

		Iterator<String> iterColumns = entity.getColumns().iterator();

		String strColumns = "(";
		boolean firstColumn = Boolean.TRUE;

		while (iterColumns.hasNext()) {

			if (firstColumn) {
				firstColumn = Boolean.FALSE;
			} else {
				strColumns += ",";
			}

			strColumns += iterColumns.next();

		}

		strColumns += ")";

		if (AppsUtils.isEmpty(entity.getValues())) {
			throw new AppsDataBaseException(
					AppsMessages.NOT_REPORTED_VALUE_INSERT);
		}

		Iterator<Object> iterValues = entity.getValues().iterator();

		String strValue = AppsConstants.EMPTY_STRING;
		boolean firstValue = Boolean.TRUE;

		while (iterValues.hasNext()) {

			if (firstValue) {
				firstValue = Boolean.FALSE;
			} else {
				strValue += ",";
			}

			Object value = iterValues.next();

			if (value instanceof String) {
				strValue += "'" + value.toString() + "'";
			} else if (value instanceof Integer) {
				strValue += ((Integer) value).intValue()
						+ AppsConstants.EMPTY_STRING;
			} else if (value instanceof Double) {
				strValue += ((Double) value).doubleValue()
						+ AppsConstants.EMPTY_STRING;
			} else if (value instanceof Long) {
				strValue += ((Long) value).longValue()
						+ AppsConstants.EMPTY_STRING;
			} else if (value instanceof Float) {
				strValue += ((Float) value).floatValue()
						+ AppsConstants.EMPTY_STRING;
			} else if (value instanceof Date) {

				String strDate = new SimpleDateFormat(
						AppsConstants.FORMAT_DATE_DD_MM_YYYY)
						.format((Date) value);

				strValue += "'" + strDate + "'";

			} else if (value == null) {
				strValue += "null";
			}

		}

		String insert = INSERT + AppsConstants.SPACE + entity.getTable()
				+ AppsConstants.SPACE + strColumns + AppsConstants.SPACE
				+ VALUES + AppsConstants.SPACE + "(" + strValue + ")";

		AppsLog.debug(AppsConstants.LOG_DATABASE_TAG, insert);

		return insert;

	}

	public String createQuery() throws AppsDataBaseException {

		if (AppsUtils.isEmpty(table)) {
			throw new AppsDataBaseException(AppsMessages.NOT_REPORTED_TABLE);
		}

		String sql = createSelect() + AppsConstants.SPACE + FROM
				+ AppsConstants.SPACE + table + AppsConstants.SPACE
				+ createWhere() + AppsConstants.SPACE + createOrderBy();

		AppsLog.debug(AppsConstants.LOG_DATABASE_TAG, sql);

		return sql;

	}

	private String createSelect() {

		String select = SELECT;

		if (AppsUtils.isEmpty(columnsSelect)) {
			select += AppsConstants.SPACE + "*";
		} else {

			Iterator<String> iterSelect = columnsSelect.iterator();
			boolean firstColumn = Boolean.TRUE;

			while (iterSelect.hasNext()) {

				String column = iterSelect.next();

				if (firstColumn) {
					firstColumn = Boolean.FALSE;
				} else {
					select += ",";
				}

				select += AppsConstants.SPACE + column;

			}

		}

		return select;

	}

	private String createWhere(ArrayList<AppsWhere> params) {

		String where = AppsConstants.EMPTY_STRING;

		if (!AppsUtils.isEmpty(params)) {

			where = WHERE + AppsConstants.SPACE;

			Iterator<AppsWhere> iterParams = params.iterator();
			boolean firstParam = Boolean.TRUE;

			while (iterParams.hasNext()) {

				if (firstParam) {
					firstParam = Boolean.FALSE;
				} else {
					where += AppsConstants.SPACE + AppsWhere.UNION_AND
							+ AppsConstants.SPACE;
				}

				AppsWhere param = iterParams.next();

				where += "(" + prepareParam(param) + ")";

			}

		}

		return where;

	}

	private String createWhere() {
		return createWhere(parameters);
	}

	private String prepareParam(AppsWhere param) {

		String paramCad = AppsConstants.EMPTY_STRING;

		if (!AppsUtils.isEmpty(param.getValues())) {

			Iterator<Object> iterValues = param.getValues().iterator();
			boolean firstValue = Boolean.TRUE;

			while (iterValues.hasNext()) {

				if (firstValue) {
					firstValue = Boolean.FALSE;
				} else {
					paramCad += AppsConstants.SPACE + param.getCodeUnion()
							+ AppsConstants.SPACE;
				}

				Object obj = iterValues.next();

				paramCad += param.getColumn() + AppsConstants.SPACE
						+ prepareOperationValue(param.getCodeOperation(), obj);

			}

		}

		return paramCad;

	}

	private String prepareOperationValue(String operation, Object value) {

		String condition = AppsConstants.EMPTY_STRING;

		String startValue = AppsConstants.EMPTY_STRING;
		String endValue = AppsConstants.EMPTY_STRING;
		String valueSTR = AppsConstants.EMPTY_STRING;

		if (value instanceof String) {
			startValue = "'";
			endValue = "'";
			valueSTR = value.toString();
		} else if (value instanceof Integer) {
			valueSTR = ((Integer) value).intValue()
					+ AppsConstants.EMPTY_STRING;
		} else if (value instanceof Double) {
			valueSTR = ((Double) value).doubleValue()
					+ AppsConstants.EMPTY_STRING;
		} else if (value instanceof Long) {
			valueSTR = ((Long) value).longValue() + AppsConstants.EMPTY_STRING;
		} else if (value instanceof Date) {
			startValue = "'";
			endValue = "'";
			valueSTR = new SimpleDateFormat(
					AppsConstants.FORMAT_DATE_DD_MM_YYYY)
					.format(((Date) value));
		}

		if (operation.equals(AppsWhere.OPERATION_CONTAIN)) {
			startValue += "%";
			endValue = "%" + endValue;
			operation = "LIKE";
		} else if (operation.equals(AppsWhere.OPERATION_START_WITH)) {
			startValue += "%";
			operation = "LIKE";
		} else if (operation.equals(AppsWhere.OPERATION_END_WITH)) {
			endValue = "%" + endValue;
			operation = "LIKE";
		}

		condition += operation + AppsConstants.SPACE + startValue + valueSTR
				+ endValue;

		return condition;

	}

	private String createOrderBy() {

		String sql = AppsConstants.EMPTY_STRING;

		if (!AppsUtils.isEmpty(orderBy)) {

			sql += AppsConstants.SPACE + ORDER_BY + AppsConstants.SPACE;

			Iterator<String> iterOrderBy = orderBy.iterator();
			boolean firstOrderBy = Boolean.TRUE;

			while (iterOrderBy.hasNext()) {

				if (firstOrderBy) {
					firstOrderBy = Boolean.FALSE;
				} else {
					sql += "," + AppsConstants.SPACE;
				}

				String column = iterOrderBy.next();

				sql += column;

			}

		}

		return sql;

	}

	/**
	 * Put columns on select
	 * 
	 * @param column
	 */
	public void putColumnsSelect(String column) {
		columnsSelect.add(column);
	}

	/**
	 * Put columns on select
	 * 
	 * @param column
	 */
	public void putColumnsSelect(ArrayList<String> columns) {

		if (!AppsUtils.isEmpty(columns)) {

			Iterator<String> iterCols = columns.iterator();

			while (iterCols.hasNext()) {
				columnsSelect.add(iterCols.next());
			}

		}

	}

	/**
	 * put parameters of the query
	 * 
	 * @param column
	 * @param value
	 */
	public void putParameter(AppsWhere where) {
		parameters.add(where);
	}

	/**
	 * Put columns of the order by
	 * 
	 * @param column
	 */
	public void putOrderBy(String column) {
		orderBy.add(column);
	}

}
