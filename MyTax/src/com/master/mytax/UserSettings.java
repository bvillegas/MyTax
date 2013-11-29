package com.master.mytax;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.master.mytax.DBSetup.spinnerSQL;

public class UserSettings extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_settings);
		fnInitialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_settings, menu);
		return true;
	}
	
	public void fnInitialize(){
		fnSwitchPWDEnabled();
		
		fnPopulateState ();
		fnPopulateFields();
		
		fnSelectState   ();
		
	}
	
	public void fnPopulateState(){
		MasterActivity.fnPopulateSpinner(this, findViewById(R.id.spnState), spinnerSQL.getStates());
		addListenerStateSpinner();
	}
	
	public void addListenerStateSpinner(){
		Spinner spinner = (Spinner) findViewById(R.id.spnState);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				// TODO Auto-generated method stub
				String _state = ((Spinner) parent).getItemAtPosition(pos).toString();
				MasterActivity.fnPopulateSpinner(getBaseContext(), findViewById(R.id.spnMunicipality), spinnerSQL.getMunicipalityByState(_state));
				fnSelectMunicipality(_state);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void fnSwitchPWDEnabled(){
		
	}
	
	public void fnPopulateFields(){
		fnEnablePWDFields(((Switch) findViewById(R.id.switchPWD)).isChecked()); 
	}
	
	public void onSwitchClicked(View view) {
	    fnEnablePWDFields(((Switch) view).isChecked());
	}
	
	public void fnSelectState(){
		/*Spinner spinner = (Spinner) findViewById(R.id.spnState);
		spinner.setSelection(5);*/
	}
	
	public void fnSelectMunicipality(String _state){
		
	}
	
	public void fnEnablePWDFields(boolean enabled){
		EditText txtPwd1 =((EditText) findViewById(R.id.txtPWD1));
	    EditText txtPwd2 =((EditText) findViewById(R.id.txtPWD2));
	    txtPwd1.setEnabled(enabled);
	    txtPwd2.setEnabled(enabled);
	}

}
