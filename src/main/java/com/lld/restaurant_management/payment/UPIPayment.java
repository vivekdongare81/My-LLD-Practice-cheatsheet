package com.lld.restaurant_management.payment;

public class UPIPayment implements Payment{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing upi payment for amount: " + amount);
        return true;
    }
}
