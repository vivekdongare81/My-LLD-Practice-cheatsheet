package com.lld.ATM_system;

public class WithdrawalTransaction extends Transaction {

  public WithdrawalTransaction(String transactionId, Account account, double amount) {
    super(transactionId, account, amount);
  }

  @Override
  public void process() {
    account.debit(amount);
  }
}
