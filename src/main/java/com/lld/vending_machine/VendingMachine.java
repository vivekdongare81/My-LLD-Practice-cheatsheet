package com.lld.vending_machine;

import com.lld.vending_machine.state.VendingMachineState;

public class VendingMachine {
  private VendingMachine instance;
  private VendingMachineState currState;
  private Inventory inventory;
  private Product product;
  private double totalPayment;

  private VendingMachine() {}

  public synchronized VendingMachine getInstance() {
    if (this.instance == null) {
      this.instance = new VendingMachine();
    }
    return this.instance;
  }

  public Product addProduct(String name, int quantity, double price) {
    Product product = new Product(name, price);
    inventory.addProduct(product, quantity);
    return product;
  }

  public void restockProduct(Product product, int quantity) {
    inventory.updateQuantity(product, quantity);
  }

  public void selectProduct(Product product) {
    currState.selectProject(product);
  }

  public void insertCoin(Coin coin) {
    currState.insertCoin(coin);
  }

  public void insertNote(Note note) {
    currState.insertNote(note);
  }

  public void dispenseProduct() {
    currState.dispenseProduct();
  }

  public void returnChange() {
    currState.returnChange();
  }

  public void setState(VendingMachineState state) {
    currState = state;
  }

  public Inventory getInventory() {
    return this.inventory;
  }

  public void setCurrState(VendingMachineState state) {
    this.currState = state;
  }

  public VendingMachineState getCurrState() {
    return this.currState;
  }

public VendingMachineState getReadyState(){// TODO Auto-generated method stub
return null;}
}
