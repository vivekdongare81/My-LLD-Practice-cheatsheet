package com.lld.vending_machine.state;

import com.lld.vending_machine.Coin;
import com.lld.vending_machine.Note;
import com.lld.vending_machine.Product;
import com.lld.vending_machine.VendingMachine;

public class IdleState implements VendingMachineState {

  private VendingMachine machine;

  public IdleState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void selectProject(Product product) {
      if (machine.getInventory().isAvailable(product)) {
          System.out.println("Product selected: " + product.getName());
          machine.setSelectedProduct(product);
          machine.setState(machine.getReadyState());
      } else {
          System.out.println("Product not available: " + product.getName());
      }
  }

  @Override
  public void insertCoin(Coin coin) {
	  System.out.println("please select product");
  }

  @Override
  public void insertNote(Note note) {
	  System.out.println("please select product");
  }

  @Override
  public void dispenseProduct() {
	  System.out.println("please select product");
  }

  @Override
  public void returnChange() {
	  System.out.println("please select product");
  }
}
