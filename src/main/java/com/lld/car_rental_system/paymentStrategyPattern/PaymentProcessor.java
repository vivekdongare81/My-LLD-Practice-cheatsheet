package com.lld.car_rental_system.paymentStrategyPattern;

public class PaymentProcessor {
    public boolean processPayment(double amount, PaymentStrategy paymentStrategy) {
        paymentStrategy.processPayment(amount);
        return true; // Assume payment is successful for simplicity
    }
}
