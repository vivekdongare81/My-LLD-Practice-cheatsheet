package com.lld.ATM_system;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
  private Map<String, Account> accounts;
  private Map<String, Card> cards;

  public BankingService() {
    this.accounts = new ConcurrentHashMap<>();
    this.cards = new ConcurrentHashMap<>();
  }

  public void createAccount(String accountNumber, double initialBalance) {
    if (accounts.containsKey(accountNumber)) {
      throw new RuntimeException("Account already exits.");
    }
    accounts.put(accountNumber, new Account(accountNumber, initialBalance));
  }

  public Account getAccount(String accountNumber) {
    return accounts.get(accountNumber);
  }

  public void linkCardToAccount(String accountNumber, String cardNumber, String pin) {
    if (!accounts.containsKey(accountNumber)) {
      throw new RuntimeException("Account not found.");
    }
    cards.put(cardNumber, new Card(cardNumber, pin));
  }

  public Card getCard(String cardNumber) {
    return cards.get(cardNumber);
  }

  public boolean authenticate(String cardNumber, String pin) {
    Card card = cards.get(cardNumber);
    return card != null && card.getPin() == pin;
  }
 
  public void processTransaction(Transaction transaction) {
      transaction.process();
  }

  
}
