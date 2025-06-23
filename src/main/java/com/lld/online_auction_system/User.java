package com.lld.online_auction_system;

import java.util.ArrayList;
import java.util.List;



public class User implements NotificationObserver{
  private String userName;
  private String email;
  private List<AuctionListing> placedAuctions;

  public User(String userName, String email) {
    super();
    this.userName = userName;
    this.email = email;
    this.placedAuctions = new ArrayList<AuctionListing>();
  }

  @Override public void update(String message){
	  System.out.println(" --> Nofied "+userName+" about bid update of :"+message);
  }
  
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<AuctionListing> getPlacedAuctions() {
    return placedAuctions;
  }

  public void setPlacedAuctions(List<AuctionListing> placedAuctions) {
    this.placedAuctions = placedAuctions;
  }



}
