package com.commons.database.entity;

import java.util.ArrayList;

import com.commons.exception.AppsDataBaseException;
import com.commons.messages.AppsMessages;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 20/08/2013
 */
public class AppsWhere {

	public static String OPERATION_EQUAL = "=";
	public static String OPERATION_NOT_EQUAL = "!=";
	public static String OPERATION_LARGEST = ">";
	public static String OPERATION_SMALLER = "<";
	public static String OPERATION_CONTAIN = "contain";
	public static String OPERATION_START_WITH = "startWith";
	public static String OPERATION_END_WITH = "endWith";

	public static String UNION_AND = "AND";
	public static String UNION_OR = "OR";

	private String column;
	private String codeOperation;
	private String codeUnion;
	private ArrayList<Object> values;

	public AppsWhere(String column, String codeOperation,
			ArrayList<Object> values) throws AppsDataBaseException {

		this.column = column;
		this.codeOperation = codeOperation;
		this.values = values;

		validateOperations(Boolean.TRUE);

	}

	public AppsWhere(String column, String codeOperation, Object value)
			throws AppsDataBaseException {

		ArrayList<Object> values = new ArrayList<Object>();
		values.add(value);

		this.column = column;
		this.codeOperation = codeOperation;
		this.values = values;

		validateOperations(Boolean.TRUE);

	}

	public AppsWhere(String column, String codeOperation, String codeUnion,
			ArrayList<Object> values) throws AppsDataBaseException {

		this.column = column;
		this.codeOperation = codeOperation;
		this.codeUnion = codeUnion;
		this.values = values;

		validateOperations(Boolean.FALSE);

	}

	private void validateOperations(boolean onlyOperation)
			throws AppsDataBaseException {

		boolean existOperation = Boolean.FALSE;

		if (codeOperation.equals(OPERATION_EQUAL)) {
			existOperation = Boolean.TRUE;
		} else if (codeOperation.equals(OPERATION_NOT_EQUAL)) {
			existOperation = Boolean.TRUE;
		} else if (codeOperation.equals(OPERATION_LARGEST)) {
			existOperation = Boolean.TRUE;
		} else if (codeOperation.equals(OPERATION_SMALLER)) {
			existOperation = Boolean.TRUE;
		} else if (codeOperation.equals(OPERATION_CONTAIN)) {
			existOperation = Boolean.TRUE;
		} else if (codeOperation.equals(OPERATION_START_WITH)) {
			existOperation = Boolean.TRUE;
		} else if (codeOperation.equals(OPERATION_END_WITH)) {
			existOperation = Boolean.TRUE;
		}

		if (!existOperation) {
			throw new AppsDataBaseException(AppsMessages.OPERATION_NOT_SUPORTED);
		}

		if (!onlyOperation) {

			boolean existUnion = Boolean.FALSE;

			if (codeUnion.equals(UNION_AND)) {
				existOperation = Boolean.TRUE;
			} else if (codeUnion.equals(UNION_OR)) {
				existOperation = Boolean.TRUE;
			}

			if (!existUnion) {
				throw new AppsDataBaseException(
						AppsMessages.OPERATION_NOT_SUPORTED);
			}

		}

	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getCodeOperation() {
		return codeOperation;
	}

	public void setCodeOperation(String codeOperation) {
		this.codeOperation = codeOperation;
	}

	public String getCodeUnion() {
		return codeUnion;
	}

	public void setCodeUnion(String codeUnion) {
		this.codeUnion = codeUnion;
	}

	public void putValue(Object value) {
		values.add(value);
	}

	public ArrayList<Object> getValues() {
		return values;
	}

	public void setValues(ArrayList<Object> values) {
		this.values = values;
	}

}
