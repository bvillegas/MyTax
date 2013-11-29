package com.master.mytax;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

	public class calculate_isr {
		private SQLiteDatabase dbMytax = null;;
		@SuppressLint("SdCardPath")
		private static String DB_PATH = "/data/data/com.master.mytax/databases/";
		private static String dbMytax_NAME = "MyTax.sqlite";
		
		  
     public Tax_Details calculate_MyIsr(Tax_Details cTax) { // int year, double income, double withholding, double deductions) {
    	  String Myquery; 
    	  //Tax_Details cTax = new Tax_Details();
     	  String myPath = DB_PATH + dbMytax_NAME;
		  dbMytax = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		  
		  double taxable_a = cTax.getIncomes() - cTax.getDeductions(); //income - deductions;
		  
		  Myquery = "SELECT LIMIT_LOW, FIX_AMOUNT, PORCENTAGE FROM TARIFAS_ISR " +
		             "WHERE YEAR = " + cTax.getYear() + " AND LIMIT_LOW <= " + taxable_a  +
		             " AND LIMIT_HIGH >= " + taxable_a;
		  Cursor c = dbMytax.rawQuery(Myquery, null);
		  if(c != null && c.moveToFirst()){
			      String llow =  c.getString(0);
		          String bases = c.getString(1);
		          String rates = c.getString(2);
		          double llowr = Double.valueOf(llow);
		          double baset = Double.valueOf(bases);
		          double rate = Double.valueOf(rates);
		          double isr_a = baset + ((taxable_a-llowr)*rate/100);
		          double bal_a = isr_a - cTax.getWithholdings();
		          cTax.setTaxable(taxable_a);
		          cTax.setIsr(isr_a);
		          cTax.setBalance(bal_a);
			}
		  c.close();
		  

		  
		if(dbMytax != null){dbMytax.close();}
    	return cTax; 
	  }

     public void calculate_totals(Tax_Details cTax) {
    	  String Myquery;
    	  double salary_year = 0.0;
    	  String myPath = DB_PATH + dbMytax_NAME;
		  dbMytax = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		  
		  Myquery = "select sum(amount*months) value from INCOMES where year in (2011, " + cTax.getYear() + ")";
		  Cursor c = dbMytax.rawQuery(Myquery, null);
		  String value_T;
		  if(c != null && c.moveToFirst()){
	    	   value_T =  c.getString(0);
	    	   cTax.setIncomes(Double.valueOf(value_T));
			}
		  c.close();
    	  
		  Myquery = "select sum(amount*months) value from WITHHOLDINGS where year in (2011, " + cTax.getYear() + ")";
		  c = dbMytax.rawQuery(Myquery, null);
		  if(c != null && c.moveToFirst()){
		    	  value_T =  c.getString(0);
		    	  cTax.setWithholdings(Double.valueOf(value_T));
			}
		  c.close();
		  
		  //cTax.getIncomes();
		  Myquery = "Select salario_minimo*365 year_salary from AREAS_GEOGRAFICAS ag, USER_SETTINGS us  where year =  " + cTax.getYear() + " and ag.area = us.area";
		  c = dbMytax.rawQuery(Myquery, null);
		  if(c != null && c.moveToFirst()){
		    	  value_T =  c.getString(0);
		    	  salary_year = Double.valueOf(value_T);
			}
		  c.close();
		  		   
		  Myquery = " select sum(case when UOM = 'NL' then d.AMOUNT " + 
				    " when UOM = 'MOM' and d.AMOUNT > dc.ANNUAL_LIMIT then dc.ANNUAL_LIMIT " +
				    " when UOM = 'MOM' and d.AMOUNT <= dc.ANNUAL_LIMIT then d.AMOUNT " +
			    	" when UOM = 'SMA' and d.AMOUNT > " +  salary_year + " then " +  salary_year + 
				    " when UOM = 'SMA' and d.AMOUNT <= " + salary_year + " then d.AMOUNT " +
			    	" when UOM = 'UIN' and d.AMOUNT > 150000 then 150000 " +
				    " when UOM = 'UIN' and d.AMOUNT <= 150000 then d.AMOUNT " +
			    	" when UOM = 'PIA' and d.AMOUNT > (" +  cTax.getIncomes() + "*dc.ANNUAL_LIMIT)/100  then (" +  cTax.getIncomes() + "*dc.ANNUAL_LIMIT)/100 " +
				    " when UOM = 'PIA' and d.AMOUNT <= (" +  cTax.getIncomes() + "*dc.ANNUAL_LIMIT)/100 then d.AMOUNT " +
				    " else 'No' end) as Value  " +
				    " from DEDUCTIONS d, DEDUCTION_CATALOG dc where d.DEDUCTION_TYPE= dc.DEDUCTION_TYPE  " +
			   	    " and d.year = dc.year  and d.year in (2011, " +  cTax.getYear() + ")";
		  c = dbMytax.rawQuery(Myquery, null);
		  if(c != null && c.moveToFirst()){
		    	  value_T =  c.getString(0);
		    	  cTax.setDeductions(Double.valueOf(value_T));
		  	}
		  	c.close();
		  
		if(dbMytax != null){dbMytax.close();}
	  }

	
	}
	
