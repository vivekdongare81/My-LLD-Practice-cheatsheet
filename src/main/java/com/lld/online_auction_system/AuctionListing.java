package com.lld.online_auction_system;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AuctionListing implements NotificationSubject {
  private final String id;
  private final User seller;
  private final Item item;
  private final LocalDateTime startTime;
  private final LocalDateTime endTime;
  private final double startBidAmount;
  private AuctionStatus status;
  private final List<Bid> bidsHistory;
  private Bid highestBid;

  private List<NotificationObserver> observers = new ArrayList<>(); // Added observers list

  public AuctionListing(
      User seller,
      Item item,
      LocalDateTime startTime,
      LocalDateTime endTime,
      double startBidAmount) {
    super();
    this.id = UUID.randomUUID().toString();
    this.seller = seller;
    this.item = item;
    this.startBidAmount = startBidAmount;
    this.startTime = startTime; // scheduled
    this.endTime = endTime;
    this.status = AuctionStatus.ANNOUNCED;
    this.bidsHistory = new ArrayList<Bid>();
    this.highestBid = new Bid(startBidAmount, null); // dummy bid
  }

  public void startBidding() {
    this.status = AuctionStatus.BIDDING;
    System.out.println("Bidding Started for item - " + item.getName());
  }

  public void placeBid(Bid bid) {

    if (status != AuctionStatus.BIDDING) {
      System.out.println("Opps, Bidding is not Active..");
      return;
      // throw new IllegalStateException("Opps, Bidding is not Active..");
    }

    if (bid.getAmount() <= highestBid.getAmount()) {
      System.out.println("Bidding ammount should be greater than highest Bid..");
      return;
      // throw new IllegalStateException("Bidding ammount should be greater than highest Bid..");
    }
    this.highestBid = bid;
    this.bidsHistory.add(bid);
    System.out.println(
        "Highest Bid changed to - " + bid.getAmount() + " for Item - " + item.getName());
    
    addObserver(bid.getBidder());
    notifyObeservers(""+bid.getAmount());
  }

  public void closeBidding() {
    this.status = AuctionStatus.CLOSED;
    System.out.println(
        "Bidding Closed for item - " + item + " , Winner -" + highestBid.getBidder().getUserName());
  }

  public boolean isActive() {
    return status == AuctionStatus.BIDDING;
  }

  	// Observer DP
	@Override
	public void notifyObeservers(String message) {
		for (NotificationObserver observer : observers) {
			observer.update(message);
		}
	}

	@Override
	public void addObserver(NotificationObserver observer) {
		if(!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void removeObserver(NotificationObserver observer) {
		observers.add(observer);
	}

  public AuctionStatus getStatus() {
    return status;
  }

  public void setStatus(AuctionStatus status) {
    this.status = status;
  }

  public Bid getHighestBid() {
    return highestBid;
  }

  public void setHighestBid(Bid highestBid) {
    this.highestBid = highestBid;
  }

  public String getId() {
    return id;
  }

  public User getSeller() {
    return seller;
  }

  public Item getItem() {
    return item;
  }

  public double getStartBidAmount() {
    return startBidAmount;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public List<Bid> getBids() {
    return bidsHistory;
  }
}
