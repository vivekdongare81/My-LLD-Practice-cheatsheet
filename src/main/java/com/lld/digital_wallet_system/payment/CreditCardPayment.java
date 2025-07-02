package com.lld.digital_wallet_system.payment;

import com.lld.digital_wallet_system.User;

public class CreditCardPayment extends PaymentStrategy  {
  private final String cardNumber;
  private final String expirationDate;
  private final String cvv;

  public CreditCardPayment(String id, User user, String cardNumber, String expirationDate, String cvv) {
    super(id, user);
    this.cardNumber = cardNumber;
    this.expirationDate = expirationDate;
    this.cvv = cvv;
  }

  @Override
  public void processPayment(double amount) {
    System.out.println("Processing credit card payment of $" + amount);
  }
}
