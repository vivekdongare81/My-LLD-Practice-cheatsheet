package com.lld.ATM_system;

public class DepositTransaction extends Transaction {

  public DepositTransaction(String transactionId, Account account, double amount) {
    super(transactionId, account, amount);
  }

  @Override
  public void process() {
    account.credit(amount);
  }
}
