package com.lld.vending_machine;

public class App {
  public static void main(String[] args) {
      VendingMachine vendingMachine = VendingMachine.getInstance();
      Product book = vendingMachine.addProduct("book",5, 50);
      Product pen = vendingMachine.addProduct("Pen",15, 5);
      
      vendingMachine.selectProduct(book);
      System.out.println(vendingMachine.getCurrState());

      vendingMachine.insertCoin(Coin.DIME);
      vendingMachine.insertCoin(Coin.QUARTER);
      
      System.out.println(vendingMachine.getCurrState());
      vendingMachine.dispenseProduct();
      
      vendingMachine.returnChange();

  }
}
