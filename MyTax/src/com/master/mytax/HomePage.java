package com.master.mytax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

import com.master.mytax.DBSetup.spinnerSQL;

public class HomePage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		fnInitialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}
	
	public void fnInitialize(){
		MainActivity.CreateDataBase(this);
		fnPopulateSpinnerFY();
		addListenerSpinnerFY();
	}
	
	public void fnPopulateSpinnerFY(){
		MasterActivity.fnPopulateSpinner(getBaseContext(),findViewById(R.id.spnFY), spinnerSQL.getFiscalYear());
	}
	
	
	public void addListenerSpinnerFY(){
		Spinner spinner = (Spinner) findViewById(R.id.spnFY);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				// TODO Auto-generated method stub
				fnEnableComponents(((Spinner) parent).getItemAtPosition(pos).toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
	
	public void fnEnableComponents(String strFY){
		boolean isComponentEnabled = !strFY.equals("");
		((Button) findViewById(R.id.btnIncomes     )).setEnabled(isComponentEnabled);
		((Button) findViewById(R.id.btnWithholdings)).setEnabled(isComponentEnabled);
		((Button) findViewById(R.id.btnDeducs      )).setEnabled(isComponentEnabled);
		((Button) findViewById(R.id.btnTxWDeducs   )).setEnabled(isComponentEnabled);
		((Button) findViewById(R.id.btnTxDeducs    )).setEnabled(isComponentEnabled);
	}
	
	
	
	
	/**
	 * @param view
	 */
	public void clickSetup(View view){
		Intent i = new Intent();
		
		     if(view.getId() == R.id.btnIncomes        ) i = new Intent(getBaseContext(),UserSettings   .class);
		else if(view.getId() == R.id.btnWithholdings   ) i = new Intent(getBaseContext(),UserSettings   .class);
		else if(view.getId() == R.id.btnDeducs         ) i = new Intent(getBaseContext(),DeductionsTable.class);
		else if(view.getId() == R.id.btnTxDeducs       ) i = new Intent(getBaseContext(),MainActivity   .class);
		else if(view.getId() == R.id.btnTxWDeducs      ) i = new Intent(getBaseContext(),MainActivity   .class);
		
		else if(view.getId() == R.id.btnSetup          ) i = new Intent(getBaseContext(),UserSettings   .class);
		
		startActivity(i);
	}

}
