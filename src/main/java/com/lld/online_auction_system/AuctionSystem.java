package com.lld.online_auction_system;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AuctionSystem {
  private static AuctionSystem instance;
  private final Map<String, User> users;
  private final Map<String, AuctionListing> auctions;
  private final ScheduledExecutorService scheduledExecutorService;

  private AuctionSystem() {
    this.users = new ConcurrentHashMap<>();
    this.auctions = new ConcurrentHashMap<>();
    this.scheduledExecutorService = Executors.newScheduledThreadPool(5);
  }

  public static AuctionSystem getInstance() {
    if (instance == null) {
      synchronized (AuctionSystem.class) {
        if (instance == null) {
          instance = new AuctionSystem();
        }
      }
    }
    return instance;
  }

  public User registerUser(String username, String name) {
    User user = new User(username, name);
    users.put(username, user);
    return user;
  }

  public User getUser(String userId) {
    return users.get(userId);
  }

  public AuctionListing announceAuction(
      User bidder,
      Item item,
      LocalDateTime startTime,
      LocalDateTime endTime,
      double startBidAmount) {
    AuctionListing auction = new AuctionListing(bidder, item, startTime, endTime, startBidAmount);
    auctions.put(auction.getId(), auction);
    
    if(startTime.isAfter(endTime)) {
    	throw new IllegalArgumentException("startTime can not be after endTime");
    }
    
    // Schedule OPENING - Calculate delay in milliseconds from now until `end`
    long delay = Duration.between(LocalDateTime.now(), startTime).toMillis();
    Runnable startTask = auction::startBidding; 

    scheduledExecutorService.schedule(startTask, delay, TimeUnit.MILLISECONDS);

    // Schedule CLOSING
    long delay2 = Duration.between(LocalDateTime.now(), endTime).toMillis();
    Runnable closeTask = auction::closeBidding;

    scheduledExecutorService.schedule(closeTask, delay2, TimeUnit.MILLISECONDS);
    System.out.println("Auction created: " + auction.getId());
    
    return auction;
  }

  public void placeBid(String auctionId, User bidder, long amount) {
    AuctionListing auction = auctions.get(auctionId);
    if (auction == null) throw new IllegalArgumentException("Invalid auction ID");
    auction.placeBid(new Bid(amount, bidder));
  }

  public List<AuctionListing> viewActiveAuctions() {
	//	or  return auctions.values().stream().filter(e->e.getStatus() == AuctionStatus.BIDDING).toList();
    return auctions.values().stream().filter(AuctionListing::isActive).toList();
  }

  public void shutdown() {
    scheduledExecutorService.shutdown();
  }
}
