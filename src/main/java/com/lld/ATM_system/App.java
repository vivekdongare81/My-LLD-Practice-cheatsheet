package com.lld.ATM_system;

public class App {
  public static void main(String[] args) {
	  BankingService bankingService = new BankingService();
	  CashDispenser cashDispenser = new CashDispenser(1000);
	  //create Dummy accounts with bank balance
	  bankingService.createAccount("account1", 100);
	  //create Dummy card with same account name(can make link inside Card as Account foreign key)
	  Card card = new Card("card1","1234");
	  bankingService.linkCardToAccount("account1", card.getCardNumber(), card.getPin());
	
	  
	  ATM atm = new ATM(bankingService, cashDispenser);
	  
	  atm.authenticate(card);
	  System.out.println(atm.checkBalance("account1"));
	  atm.withdrawCash("account1", 5);
	  System.out.println(atm.checkBalance("account1"));
	  atm.depositCash("account1", 10);
	  System.out.println(atm.checkBalance("account1"));


  }
}
