package com.lld.vending_machine.state;

import com.lld.vending_machine.Coin;
import com.lld.vending_machine.Note;
import com.lld.vending_machine.Product;
import com.lld.vending_machine.VendingMachine;

public class ReturnChangeState implements VendingMachineState {

  private VendingMachine machine;

  public ReturnChangeState(VendingMachine machine) {
    this.machine = machine;
  }

  public void selectProject(Product product) {
    System.out.println("please collect change");
  }

  @Override
  public void insertCoin(Coin coin) {
    System.out.println("please collect change");
  }

  @Override
  public void insertNote(Note note) {
    System.out.println("please collect change");
  }

  @Override
  public void dispenseProduct() {
    System.out.println("please collect change");
  }

  @Override
  public void returnChange() {
    double change = machine.getTotalPayment() - machine.getSelectedProduct().getPrice();
    if (change > 0) {
      System.out.println("Change returned: $" + change);
    } else {
      System.out.println("No change to return.");
    }

    machine.resetPayment();
    machine.resetSelectedProduct();
    machine.setState(machine.getIdleState());
  }
}
