package com.lld.ATM_system;

public class CashDispenser {
  private int availableCash;

  public CashDispenser(int availableCash) {
    this.availableCash = availableCash;
  }
  public synchronized void dispenseCash(int amount) {
	  if(amount > availableCash) {
		  throw new IllegalArgumentException("Insufficient cash available.");
	  }
	  availableCash -= amount;
	  System.out.println("Cash Dispensed - "+amount);
  }

}
