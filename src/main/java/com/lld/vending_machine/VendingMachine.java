package com.lld.vending_machine;

import com.lld.vending_machine.state.DispenseState;
import com.lld.vending_machine.state.IdleState;
import com.lld.vending_machine.state.ReadyState;
import com.lld.vending_machine.state.ReturnChangeState;
import com.lld.vending_machine.state.VendingMachineState;

public class VendingMachine {
  private static VendingMachine instance;

  private final VendingMachineState idleState;
  private final VendingMachineState readyState;
  private final VendingMachineState dispenseState;
  private final VendingMachineState returnChangeState;

  private VendingMachineState currState;
  private Inventory inventory;
  private Product selectedProduct;
  private double totalPayment;

  private VendingMachine() {
    inventory = new Inventory();
    idleState = new IdleState(this);
    readyState = new ReadyState(this);
    dispenseState = new DispenseState(this);
    returnChangeState = new ReturnChangeState(this);
    currState = idleState;
    selectedProduct = null;
    totalPayment = 0.0;
  }

  public static synchronized VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachine();
    }
    return instance;
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

  public VendingMachineState getIdleState() {
    return idleState;
  }

  public VendingMachineState getReadyState() {
    return readyState;
  }

  public VendingMachineState getDispenseState() {
    return dispenseState;
  }

  public VendingMachineState getReturnChangeState() {
    return returnChangeState;
  }

  public Product getSelectedProduct() {
    return this.selectedProduct;
  }

  public double getTotalPayment() {
    return this.totalPayment;
  }

  public void resetPayment() {
    this.totalPayment = 0;
  }

  public void resetSelectedProduct() {
    this.selectedProduct = null;
  }

  public void setSelectedProduct(Product product) {
    this.selectedProduct = product;
  }

  public void addCoin(Coin coin) {
      totalPayment += coin.getValue();
  }

  void addNote(Note note) {
      totalPayment += note.getValue();
  }
}
