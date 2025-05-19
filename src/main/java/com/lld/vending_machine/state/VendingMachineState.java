package com.lld.vending_machine.state;

import com.lld.vending_machine.Coin;
import com.lld.vending_machine.Note;
import com.lld.vending_machine.Product;

public interface VendingMachineState {
  void selectProject(Product product);

  void insertCoin(Coin coin);

  void insertNote(Note note);

  void dispenseProduct();

  void returnChange();
}
