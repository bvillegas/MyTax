package com.master.mytax;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MasterActivity extends Activity{
	
	public static void fnPopulateSpinner(Context context, View view, String sqlQuery){
		Spinner spinner = (Spinner) view;
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,getAllLabels(sqlQuery));
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
	
	public static List<String> getAllLabels(String sqlQuery){
		List<String> array_label = new ArrayList<String>();
		Cursor cursorData = DBConnection.selectQuery(sqlQuery);
		array_label.add("");
		if(cursorData.moveToFirst()){
			do{
				array_label.add(cursorData.getString(0));
			}while(cursorData.moveToNext());
		}
		return array_label;
	}

}
