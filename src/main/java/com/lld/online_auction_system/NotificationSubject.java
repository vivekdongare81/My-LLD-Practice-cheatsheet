package com.lld.online_auction_system;



public interface NotificationSubject {
	void addObserver(NotificationObserver observer);
	void removeObserver(NotificationObserver observer);
	void notifyObeservers(String message);
}