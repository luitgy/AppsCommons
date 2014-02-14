package com.commons.database;

import com.commons.exception.AppsDataBaseException;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 21/08/2013
 */
public abstract class AppsDataBaseController extends SQLiteOpenHelper {

	private static CursorFactory cursorFactory = null;

	public AppsDataBaseController(Context context, String dataBaseName,
			int dataBaseVersion) {
		super(context, dataBaseName, cursorFactory, dataBaseVersion);
	}

	public void updateSQL(String sql) {

		SQLiteDatabase db = getWritableDatabase();

		db.execSQL(sql);
		db.close();

	}

	public Cursor executeSQL(AppsQuery query) throws AppsDataBaseException {

		String sql = query.createQuery();

		SQLiteDatabase db = getReadableDatabase();

		return db.rawQuery(sql, null);

	}

}
