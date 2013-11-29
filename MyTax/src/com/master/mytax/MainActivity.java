package com.master.mytax;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

@SuppressLint("DefaultLocale")
public class MainActivity extends Activity {
	private SQLiteDatabase dbMytax = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MainActivity.CreateDataBase(this);
	}

	public void onClick(View view) {

	    switch (view.getId()) {
	    	case R.id.query: //calculateT(2013);
	    					//read_user();
	    		break;
	    }
	}

	public void calculateT(int vYear){
		 calculate_isr ci = new calculate_isr();
		 Tax_Details xTax = new Tax_Details  ();
		 xTax.setYear(vYear);		  
		  
		 ci.calculate_totals(xTax);
		 ci.calculate_MyIsr (xTax);
		 
		 TextView tv= (TextView) findViewById(R.id.Year);
	     tv.setText(Integer.toString(xTax.getYear             ()));
	      
	     tv= (TextView) findViewById(R.id.Incomes);
	     tv.setText(String.format("%,.2f", xTax.getIncomes    ()));
	     
		 tv= (TextView) findViewById(R.id.Withh);
	     tv.setText(String.format("%,.2f",xTax.getWithholdings()));
	     
		 tv= (TextView) findViewById(R.id.Deduc);
	     tv.setText(String.format("%,.2f",xTax.getDeductions  ()));
	     
		 tv= (TextView) findViewById(R.id.Taxable);
	     tv.setText(String.format("%,.2f",xTax.getTaxable	  ()));
	     
	     tv= (TextView) findViewById(R.id.Isr);
	     tv.setText(String.format("%,.2f",xTax.getIsr		  ()));
	     
		 tv= (TextView) findViewById(R.id.Balance);
	     tv.setText(String.format("%,.2f",xTax.getBalance     ()));
     	  
	  }
	  
	  
	  public void read_user() {

		  String myPath = DBSetup.DBSettings.DB_PATH + DBSetup.DBSettings.dbMytax_NAME;
		  
		  dbMytax = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
   		  
		  Cursor c = dbMytax.rawQuery("select AREA,STATE,MUNICIPALITY from USER_SETTINGS", null);
		   
   		  if (c.moveToFirst()) {
			     do {
			         String AREA= c.getString(0);
			         String STATE = c.getString(1);
			         String MUNICIPALITY = c.getString(2);
			 		 TextView tv= (TextView) findViewById(R.id.Withh);
			         tv.setText(AREA);
					 tv= (TextView) findViewById(R.id.Deduc);
			         tv.setText(STATE);
					 tv= (TextView) findViewById(R.id.Taxable);
			         tv.setText(MUNICIPALITY);
			          
			     } while(c.moveToNext());
			}
	    	
    	if(dbMytax != null){dbMytax.close();}

	  }
	  
	  
	  /**
	   * Validates if the DB already exists, if not, it automatically creates it
	   * @param context
	   */
	  public static void CreateDataBase(Context context){
			DataBaseHelper myDbHelper = new DataBaseHelper(null);
		    myDbHelper                = new DataBaseHelper(context);
		    
	        try {
	        	myDbHelper.createDataBase();
	        } catch (IOException ioe) {
	        		throw new Error("Unable to create database");
	        }
	        
	        try {
	        	myDbHelper.openDataBase();
	        } catch(SQLException sqle){
	        		throw sqle;
	        }
	  }		
	  

}
