package com.lld.digital_wallet_system;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.lld.digital_wallet_system.payment.PaymentStrategy;


public class DigitalWallet {
  private static DigitalWallet instance;
  private final Map<String, User> users;
  private final Map<String, Account> accounts;
  private final Map<String, PaymentStrategy> paymentStrategies;

  private DigitalWallet() {
    users = new ConcurrentHashMap<>();
    accounts = new ConcurrentHashMap<>();
    paymentStrategies = new ConcurrentHashMap<>();
  }

  public static synchronized DigitalWallet getInstance() {
    if (instance == null) {
      instance = new DigitalWallet();
    }
    return instance;
  }

  public void createUser(User user) {
    users.put(user.getId(), user);
  }

  public User getUser(String userId) {
    return users.get(userId);
  }

  public void createAccount(Account account) {
    accounts.put(account.getId(), account);
    account.getUser().addAccount(account);
  }

  public Account getAccount(String accountId) {
    return accounts.get(accountId);
  }

  public void addPaymentMethod(PaymentStrategy paymentMethod) {
	  paymentStrategies.put(paymentMethod.getId(), paymentMethod);
  }

  public PaymentStrategy getPaymentMethod(String paymentMethodId) {
    return paymentStrategies.get(paymentMethodId);
  }

  public synchronized void transferFunds(
      Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency) {
    if (sourceAccount.getCurrency() != currency) {
      amount = CurrencyConverter.convert(amount, currency, sourceAccount.getCurrency());
    }
    sourceAccount.withdraw(amount);

    if (destinationAccount.getCurrency() != currency) {
      amount = CurrencyConverter.convert(amount, currency, destinationAccount.getCurrency());
    }
    destinationAccount.deposit(amount);

    String transactionId = generateTransactionId();
    Transaction transaction =
        new Transaction(
            transactionId,
            sourceAccount,
            destinationAccount,
            amount,
            destinationAccount.getCurrency());
    sourceAccount.addTransaction(transaction);
    destinationAccount.addTransaction(transaction);
  }

  public List<Transaction> getTransactionHistory(Account account) {
    return account.getTransactions();
  }

  private String generateTransactionId() {
    return "TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
  }
}
