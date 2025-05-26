package com.lld.coffee_vending_machine;

public class PaymentProcessor {
  public double processPayment(double price, double paid) {
    System.out.println("Processing payment ...");
    return paid - price;
  }
}
