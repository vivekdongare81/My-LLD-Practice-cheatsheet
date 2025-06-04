package com.lld.ATM_system;

public class Account {
  private final String accountNumber;
  private double balance;

  public Account(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public void debit(double amount) {
    balance -= amount;
  }

  public void credit(double amount) {
    balance += amount;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
}
