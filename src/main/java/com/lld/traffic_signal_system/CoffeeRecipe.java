package com.lld.traffic_signal_system;

import java.util.Map;

public class CoffeeRecipe {
  private String name;
  private Double price;
  private Map<String, Integer> recipe;

  public CoffeeRecipe(String name, Double price, Map<String, Integer> ingredients) {
    this.name = name;
    this.price = price;
    this.recipe = ingredients;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Map<String, Integer> getIngredients() {
    return recipe;
  }

  public void setIngredients(Map<String, Integer> ingredients) {
    this.recipe = ingredients;
  }
}
