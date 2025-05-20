package com.lld.vending_machine.state;

import com.lld.vending_machine.Coin;
import com.lld.vending_machine.Note;
import com.lld.vending_machine.Product;
import com.lld.vending_machine.VendingMachine;

public class DispenseState implements VendingMachineState {

  private VendingMachine machine;

  public DispenseState(VendingMachine machine) {
    this.machine = machine;
  }

  public void selectProject(Product product) {
	  System.out.println("please collect product");
  }

  @Override
  public void insertCoin(Coin coin) {
	  System.out.println("please collect product");
  }

  @Override
  public void insertNote(Note note) {
	  System.out.println("please collect product");
  }

  @Override
  public void dispenseProduct() {
	   Product product = machine.getSelectedProduct();
	   machine.getInventory().updateQuantity(product, machine.getInventory().getQuantity(product) - 1);
       System.out.println("Product dispensed: " + product.getName());
       machine.setState(machine.getReturnChangeState()); // Change the state to ReturnChangeState
  }

  @Override
  public void returnChange() {
	  System.out.println("please collect product");
  }
}
