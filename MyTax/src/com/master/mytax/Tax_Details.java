package com.master.mytax;

public class Tax_Details {
	  private int 		year		;
	  private double 	incomes		;
	  private double 	withholdings;
	  private double 	deductions	;
	  private double 	taxable		;
	  private double 	isr			;
	  private double 	balance		;

	  public int    getYear        () {
		    return year;
		  }
	  public double getIncomes     () {
		    return incomes;
		  }
	  public double getWithholdings() {
		    return withholdings;
		  }
	  public double getDeductions  () {
		    return deductions;
		  }
	  public double getTaxable     () {
	    return taxable;
	  }
	  public double getIsr         () {
		    return isr;
		  }
	  public double getBalance     () {
		    return balance;
		  }
	  
	  public void setYear        (int    year        ) {
	    this.year = year;
	  }
	  public void setIncomes     (double incomes     ) {
		    this.incomes = incomes;
		  }
	  public void setWithholdings(double withholdings) {
		    this.withholdings = withholdings;
		  }
	  public void setDeductions  (double deductions  ) {
		    this.deductions = deductions;
		  }
	  public void setTaxable     (double taxable     ) {
		    this.taxable = taxable;
		  }
	  public void setIsr         (double isr         ) {
		    this.isr = isr;
		  }
	  public void setBalance	 (double balance     ) {
		    this.balance = balance;
		  }

	} 