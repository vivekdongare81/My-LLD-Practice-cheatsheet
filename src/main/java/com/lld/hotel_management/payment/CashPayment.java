package com.lld.hotel_management.payment;

public class CashPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        // Process cash payment
        return true;
    }
}
