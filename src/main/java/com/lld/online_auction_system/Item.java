package com.lld.online_auction_system;

public class Item {
  private final String name;
  private final String description;

  public Item(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }
}
