package com.lld.traffic_signal_system;

public class PaymentProcessor {
  public double processPayment(double price, double paid) {
    System.out.println("Processing payment ...");
    return paid - price;
  }
}
