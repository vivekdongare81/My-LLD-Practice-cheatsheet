package com.lld.vending_machine.state;

import com.lld.vending_machine.Coin;
import com.lld.vending_machine.Note;
import com.lld.vending_machine.Product;
import com.lld.vending_machine.VendingMachine;

public class IdleState implements VendingMachineState {

  private VendingMachine machine;

  IdleState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void selectProject(Product product) {
      if (machine.getInventory().isAvailable(product)) {
          System.out.println("Product selected: " + product.getName());
          machine.selectProduct(product);
          machine.setState(machine.getReadyState());
      } else {
          System.out.println("Product not available: " + product.getName());
      }
  }

  @Override
  public void insertCoin(Coin coin) {
    // TODO Auto-generated method stub

  }

  @Override
  public void insertNote(Note note) {
    // TODO Auto-generated method stub

  }

  @Override
  public void dispenseProduct() {
    // TODO Auto-generated method stub

  }

  @Override
  public void returnChange() {
    // TODO Auto-generated method stub

  }
}
