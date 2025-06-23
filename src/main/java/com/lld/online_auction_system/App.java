package com.lld.online_auction_system;

import java.time.LocalDateTime;

public class App {
  public static void main(String[] args) throws InterruptedException {
	  
	  AuctionSystem auctionSystem = AuctionSystem.getInstance();
	  
	  User user1 = auctionSystem.registerUser("vivek", "viv@email");
	  User user2 = auctionSystem.registerUser("rohan", "aa@email");
	  User user3 = auctionSystem.registerUser("shan", "bb@email");
	  
	  Item car = new Item("Car", "Ferarri");
	  LocalDateTime startTime = LocalDateTime.now().plusSeconds(10);
	  LocalDateTime closeTime = LocalDateTime.now().plusSeconds(20);
	  AuctionListing carAuction = auctionSystem.announceAuction(user1, car, startTime, closeTime, 100);
	  
	  
	  System.out.println("Auction starts in sec: "+10); 
	  System.out.println("Auction closes in sec: "+20);
	  
	  Thread.sleep(15000); //wait 15 sec

	  
	  auctionSystem.viewActiveAuctions().forEach(e -> System.out.println(e.getItem()));

	  carAuction.placeBid(new Bid(120, user2));
	  carAuction.placeBid(new Bid(150, user3));
	  carAuction.placeBid(new Bid(130, user2));
	  carAuction.placeBid(new Bid(200, user2));

	  Thread.sleep(15000); //wait extra 10 sec = total 25 sec after bid starts
	  
	  carAuction.placeBid(new Bid(150, user3)); //Invalid timing
	  
	  
	  auctionSystem.shutdown(); // stop the executor service after processing pending tasks

	  
  }
}
