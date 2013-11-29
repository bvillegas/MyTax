package com.master.mytax;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class DeductionsTable extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deductions_table);
		fnInitialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.deductions_table, menu);
		return true;
	}
	
	protected void fnInitialize(){
		
	}
	
	
	/**
	 * 
	 * @param view
	 */
	
	public void onClickButton(View view){
		
		
		     if(view.getId() == R.id.btnAdd    ){ 
		    	 Intent i  = new Intent(getBaseContext(),AddDeduction.class); 
		    	 startActivity(i);
		    	 }
		else if(view.getId() == R.id.btnRemove ){ }
		else if(view.getId() == R.id.btnEdit   ){ } 
				
		
	}

}
