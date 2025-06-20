package com.lld.car_rental_system.paymentStrategyPattern.ConcretePaymentStrategies;

import com.lld.car_rental_system.paymentStrategyPattern.PaymentStrategy;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Logic for PayPal payment processing would go here
    }
}
