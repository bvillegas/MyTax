package com.master.mytax;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.master.mytax.DBSetup.*;

public class DBConnection {
	private static SQLiteDatabase dbMytax = null;
	private static final String DB_Path = DBSettings.DB_PATH + DBSettings.dbMytax_NAME;
	
	
	public static Cursor selectQuery(String sqlQuery){
		try{
		Cursor cursorDB;
		dbMytax = SQLiteDatabase.openDatabase(DB_Path, null , SQLiteDatabase.OPEN_READONLY);
		cursorDB = dbMytax.rawQuery(sqlQuery, null);
		return cursorDB;
		}  catch(SQLException sqle){
			throw sqle;
		}
	}

}
