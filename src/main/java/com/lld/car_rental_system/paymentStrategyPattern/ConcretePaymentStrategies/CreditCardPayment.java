package com.lld.car_rental_system.paymentStrategyPattern.ConcretePaymentStrategies;

import com.lld.car_rental_system.paymentStrategyPattern.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
