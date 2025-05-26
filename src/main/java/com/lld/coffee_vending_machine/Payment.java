package com.lld.coffee_vending_machine;

public class Payment {
  private double ammount;

  public Payment(double ammount) {
    this.ammount = ammount;
  }

  public double getAmmount() {
    return ammount;
  }

  public void setAmmount(double ammount) {
    this.ammount = ammount;
  }
}
