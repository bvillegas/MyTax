package com.master.mytax;

import android.provider.BaseColumns;

public final class DBSetup {
	
	public static abstract class DBSettings{
		public static final String DB_PATH = "/data/data/com.master.mytax/databases/";
		public static final String dbMytax_NAME = "MyTax.sqlite";
	}
	
	public static abstract class spinnerSQL{
		private static final String spnFY     = "SELECT DISTINCT " + AreasGeograficas.COLUMN_NAME_YEAR + " FROM " + AreasGeograficas.TABLE_NAME  ;
		private static final String spnStates = "SELECT "          + States.COLUMN_NAME_DESCRIPTION    + " FROM " + States.TABLE_NAME 			;
		public static String getFiscalYear(){
			return spnFY;
		}
		public static String getStates(){
			return spnStates;
		}
		public static String getMunicipalityByState(String state){
			String 	sqlQuery =  "SELECT MP."+ Municipality.COLUMN_NAME_MUNICIPALITY + " ";
					sqlQuery += "FROM "     + Municipality.TABLE_NAME       + " MP" + " ";
					sqlQuery += "WHERE MP." + Municipality.COLUMN_NAME_STATE_CODE + " = (SELECT " + States.COLUMN_NAME_STATE_CODE + " ";
					sqlQuery +=                        "FROM " + States.TABLE_NAME + " ";
					sqlQuery += 					"WHERE " + States.COLUMN_NAME_DESCRIPTION +  " = '" + state + "') ";
					sqlQuery += "ORDER BY MP."+ Municipality.COLUMN_NAME_MUNICIPALITY;
			return sqlQuery;
		}
	}
	
	public static abstract class UserSettings implements BaseColumns{
		public static final String TABLE_NAME 				= "USER_SETTINGS"	;
        public static final String COLUMN_NAME_AREA 		= "AREA"			;
        public static final String COLUMN_NAME_PWD_ENABLE 	= "PASSWORD_ENABLE"	;
        public static final String COLUMN_NAME_PWD			= "PASSWORD"		;
        public static final String COLUMN_NAME_MUNICIPALITY = "MUNICIPALITY"	;
	}
	
	public static abstract class AreasGeograficas implements BaseColumns{
		public static final String TABLE_NAME 				= "AREAS_GEOGRAFICAS"	;
        public static final String COLUMN_NAME_YEAR 		= "YEAR"				;
        public static final String COLUMN_NAME_AREA 		= "AREA"				;
        public static final String COLUMN_NAME_SALARIO_MIN 	= "SALARIO_MINIMO"		;
	}
	public static abstract class States implements BaseColumns{
		public static final String TABLE_NAME 				= "STATES"		;
        public static final String COLUMN_NAME_STATE_CODE	= "STATE_CODE"	;
        public static final String COLUMN_NAME_DESCRIPTION 	= "DESCRIPTION"	;
	}
	public static abstract class Municipality implements BaseColumns{
		public static final String TABLE_NAME 				= "MUNICIPALITY";
        public static final String COLUMN_NAME_STATE_CODE 	= "STATE_CODE"	;
        public static final String COLUMN_NAME_MUNICIPALITY = "MUNICIPALITY";
        public static final String COLUMN_NAME_AREA 		= "AREA"		;
	}
	public static abstract class OUM implements BaseColumns{
		public static final String TABLE_NAME 				= "UOM"			;
        public static final String COLUMN_NAME_UOM 			= "UOM"			;
        public static final String COLUMN_NAME_DESCRIPTION 	= "DESCRIPTION"	;
	}
	public static abstract class TarifasISR implements BaseColumns{
		public static final String TABLE_NAME 				= "TARIFAS_ISR"	;
        public static final String COLUMN_NAME_YEAR			= "YEAR"		;
        public static final String COLUMN_NAME_LIMIT_LOW 	= "LIMIT_LOW"	;
        public static final String COLUMN_NAME_LIMIT_HIGH	= "LIMIT_HIGH"	;
        public static final String COLUMN_NAME_FIX_AMOUNT 	= "FIX_AMOUNT"	;
        public static final String COLUMN_NAME_PERCENTAGE 	= "PORCENTAGE"	;
	}
	public static abstract class LookupTable implements BaseColumns{
		public static final String TABLE_NAME 				= "LOOKUP_TABLE";
        public static final String COLUMN_NAME_YEAR 		= "YEAR"		;
        public static final String COLUMN_NAME_TYPE 		= "TYPE"		;
        public static final String COLUMN_NAME_CATEGORY 	= "CATEGORY"	;
        public static final String COLUMN_NAME_DESCRIPTION = "DESCRIPTION"	;
	}
	public static abstract class DeductionCatalog implements BaseColumns{
		public static final String TABLE_NAME 					= "DEDUCTION_CATALOG"	;
        public static final String COLUMN_NAME_YEAR 			= "YEAR"				;
        public static final String COLUMN_NAME_DEDUCTION_TYPE 	= "DEDUCTION_TYPE"		;
        public static final String COLUMN_NAME_ANNUAL_LIMIT 	= "ANNUAL_LIMIT"		;
        public static final String COLUMN_NAME_UOM 				= "UOM"					;
	}
	public static abstract class WithHoldings implements BaseColumns{
		public static final String TABLE_NAME 					= "WITHHOLDINGS"	;
        public static final String COLUMN_NAME_ID 				= "_ID"				;
        public static final String COLUMN_NAME_YEAR 			= "YEAR"			;
        public static final String COLUMN_NAME_WITHHOLDING_TYPE = "WITHHOLDING_TYPE";
        public static final String COLUMN_NAME_START_DATE 		= "START_DATE"		;
        public static final String COLUMN_NAME_MONTHS 			= "MONTHS"			;
        public static final String COLUMN_NAME_AMOUNT 			= "AMOUNT"			;
	}
	public static abstract class Incomes implements BaseColumns{
		public static final String TABLE_NAME 				= "INCOMES"		;
		public static final String COLUMN_NAME_ID 			= "_ID"			;
        public static final String COLUMN_NAME_YEAR 		= "YEAR"		;
        public static final String COLUMN_NAME_INCOME_TYPE 	= "INCOME_TYPE"	;
        public static final String COLUMN_NAME_START_DATE 	= "START_DATE"	;
        public static final String COLUMN_NAME_MONTHS 		= "MONTHS"		;
        public static final String COLUMN_NAME_AMOUNT 		= "AMOUNT"		;
	}
	public static abstract class Deductions implements BaseColumns{
		public static final String TABLE_NAME 					= "DEDUCTIONS"		;
		public static final String COLUMN_NAME_ID 				= "_ID"				;
        public static final String COLUMN_NAME_YEAR 			= "YEAR"			;
        public static final String COLUMN_NAME_DEDUCTION_TYPE 	= "DEDUCTION_TYPE"	;
        public static final String COLUMN_NAME_START_DATE 		= "START_DATE"		;
        public static final String COLUMN_NAME_MONTHS 			= "MONTHS"			;
        public static final String COLUMN_NAME_AMOUNT 			= "AMOUNT"			;
        
        
	}


}
