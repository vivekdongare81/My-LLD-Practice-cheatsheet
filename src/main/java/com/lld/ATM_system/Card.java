package com.lld.ATM_system;

public class Card {
  private String cardNumber;
  private String pin;

  public Card(String cardNumber, String pin) {
    super();
    this.cardNumber = cardNumber;
    this.pin = pin;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }
}
