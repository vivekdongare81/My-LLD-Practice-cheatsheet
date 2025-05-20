package com.lld.vending_machine.state;

import com.lld.vending_machine.Coin;
import com.lld.vending_machine.Note;
import com.lld.vending_machine.Product;
import com.lld.vending_machine.VendingMachine;

public class ReadyState implements VendingMachineState {

  private VendingMachine machine;

  public ReadyState(VendingMachine machine) {
    this.machine = machine;
  }

  public void selectProject(Product product) {
	  System.out.println("please insert coin/note product");
  }

  @Override
  public void insertCoin(Coin coin) {
	  machine.addCoin(coin);
      System.out.println("Coin inserted: " + coin);
      checkPaymentStatus();

  }

  @Override
  public void insertNote(Note note) {
	  machine.insertNote(note);
      System.out.println("Note inserted: " + note);
      checkPaymentStatus();
  }

  @Override
  public void dispenseProduct() {
	  System.out.println("please select product");
  }

  @Override
  public void returnChange() {
	  System.out.println("please select product");
  }
  

  private void checkPaymentStatus() {
      if (machine.getTotalPayment() >= machine.getSelectedProduct().getPrice()) {
    	  machine.setState(machine.getDispenseState());
      }else {
    	  System.out.println("less money" ); 
      }
  }
}
