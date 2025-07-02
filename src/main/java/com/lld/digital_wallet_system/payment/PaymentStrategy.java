package com.lld.digital_wallet_system.payment;

import com.lld.digital_wallet_system.User;

public abstract class PaymentStrategy {
	
    protected final String id;
    protected final User user;


    public PaymentStrategy(String id, User user) {
        this.id = id;
        this.user = user;
    }
    
    public abstract void processPayment(double amount);
    

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
