package com.lld.digital_wallet_system.payment;

import com.lld.digital_wallet_system.User;

public class BankAccountPayment extends PaymentStrategy {
    private final String accountNumber;
    private final String routingNumber;

    public BankAccountPayment(String id, User user, String accountNumber, String routingNumber) {
        super(id, user);
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }
    @Override
    public void processPayment(double amount) {
      System.out.println("Processing credit card payment of $" + amount);
    }
}
