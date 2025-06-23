package com.lld.online_auction_system;

import java.time.LocalDateTime;
import java.util.UUID;

public class Bid {
  private final String id;
  private final double amount;
  private final User bidder;
  private final LocalDateTime timestamp;

  public Bid( double amount, User bidder) {
    super();
    this.id = UUID.randomUUID().toString();
    this.amount = amount;
    this.bidder = bidder;
    this.timestamp = LocalDateTime.now();
  }

  public String getId() {
    return id;
  }

  public double getAmount() {
    return amount;
  }

  public User getBidder() {
    return bidder;
  }
}
