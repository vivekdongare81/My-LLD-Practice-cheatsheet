package com.lld.coffee_vending_machine;

import java.util.HashMap;
import java.util.Map;

public class IngredientStore {
  private Map<String, Integer> inventory;

  public IngredientStore() {
    this.inventory = new HashMap<>();
  }

  public IngredientStore(Map<String, Integer> inventory) {
    this.inventory = inventory;
  }

  public void refill(String ingredient, Integer quantity) {
    inventory.put(ingredient, inventory.getOrDefault(ingredient, 0) + quantity);
  }

  public boolean hasEnoughIngredients(Map<String, Integer> ingredients) {
    for (Map.Entry<String, Integer> ingreReq : ingredients.entrySet()) {
      if (this.inventory.getOrDefault(ingreReq.getKey(), 0) < ingreReq.getValue()) {
        return false;
      }
    }
    return true;
  }

  public synchronized void consume(Map<String, Integer> required) {
      // deduct ingredient
      for (Map.Entry<String, Integer> entry : required.entrySet()) {
          String ingredient = entry.getKey();
          inventory.put(ingredient, inventory.get(ingredient) - entry.getValue());
      }
  }

  public Map<String, Integer> getInventory() {
    return inventory;
  }

  public void setIngredient(Map<String, Integer> inventory) {
    this.inventory = inventory;
  }
}
