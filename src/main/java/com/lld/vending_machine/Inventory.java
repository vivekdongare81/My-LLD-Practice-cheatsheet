package com.lld.vending_machine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
  private final Map<Product, Integer> products;

  Inventory() {
    this.products = new ConcurrentHashMap<Product, Integer>();
  }

  public void addProduct(Product product, int quantity) {
    products.put(product, quantity);
  }

  public void updateQuantity(Product product, int quantity) {
    products.put(product, quantity);
  }

  public boolean isAvailable(Product product) {
    return products.containsKey(product) && products.get(product) > 0;
  }

  public int getQuantity(Product product) {
    return products.getOrDefault(product, 0);
  }
}
