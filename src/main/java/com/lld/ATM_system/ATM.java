package com.lld.ATM_system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {
  private final BankingService bankingService;
  private final CashDispenser cashDispenser;
  private static final AtomicLong transactionCounter = new AtomicLong(0);

  public ATM(BankingService bankingService, CashDispenser cashDispenser) {
    this.bankingService = bankingService;
    this.cashDispenser = cashDispenser;
  }

  public void authenticate(Card card) {
    boolean isAuthenticated = bankingService.authenticate(card.getCardNumber(), card.getPin());
    if (isAuthenticated) {
      System.out.println("User is authenticated.");
    } else {
      System.out.println("Authentication failed.");
    }
  }

  public double checkBalance(String accountNumber) {
    Account account = bankingService.getAccount(accountNumber);
    return account.getBalance();
  }

  public void withdrawCash(String accountNumber, double amount) {
    Account account = bankingService.getAccount(accountNumber);
    // if sufficient balance available
    if (account != null && account.getBalance() < amount) {
      System.out.println("Insufficient balance..");
      return;
    }
    Transaction transaction = new WithdrawalTransaction(generateTransactionId(), account, amount);
    bankingService.processTransaction(transaction);
  }

  public void depositCash(String accountNumber, double amount) {
    Account account = bankingService.getAccount(accountNumber);
    Transaction transaction = new DepositTransaction(generateTransactionId(), account, amount);
    bankingService.processTransaction(transaction);
  }

  private String generateTransactionId() {
    // unique transaction ID
    long transactionNumber = transactionCounter.incrementAndGet();
    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    return "TXN" + timestamp + String.format("%010d", transactionNumber);
  }
}
