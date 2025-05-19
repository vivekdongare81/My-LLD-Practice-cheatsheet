package com.lld.vending_machine.state;

import com.lld.vending_machine.Coin;
import com.lld.vending_machine.Note;
import com.lld.vending_machine.Product;
import com.lld.vending_machine.VendingMachine;

public class ReadyState implements VendingMachineState {

  private VendingMachine machine;

  ReadyState(VendingMachine machine) {
    this.machine = machine;
  }

  public void selectProject(Product product) {
	  machine.selectProduct(product);
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
