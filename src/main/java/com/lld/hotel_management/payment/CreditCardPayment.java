package com.lld.hotel_management.payment;

public class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        // Process credit card payment
        return true;
    }
}
