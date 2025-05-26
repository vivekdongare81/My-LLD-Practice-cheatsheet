package com.lld.traffic_signal_system;

import java.util.HashMap;
import java.util.Map;

public class CoffeeVendingMachine {
  private static CoffeeVendingMachine instance;
  private final Map<String, CoffeeRecipe> recipes;
  private final IngredientStore inventory;
  private final PaymentProcessor paymentProcessor;
  private final Dispenser dispenser;

  private CoffeeVendingMachine() {
    this.recipes = new HashMap<>();
    ;
    this.inventory = new IngredientStore();
    this.paymentProcessor = new PaymentProcessor();
    this.dispenser = new Dispenser();
    addDefaultRecipes();
  }

  public static CoffeeVendingMachine getInstance() {
    // double lock instance
    return new CoffeeVendingMachine();
  }

  private void addDefaultRecipes() {
    recipes.put("Espresso", new CoffeeRecipe("Espresso", 2.5, Map.of("Water", 50, "Coffee", 20)));
    recipes.put(
        "Latte", new CoffeeRecipe("Latte", 3.0, Map.of("Water", 50, "Coffee", 20, "Milk", 30)));
    recipes.put(
        "Cappuccino",
        new CoffeeRecipe("Cappuccino", 3.5, Map.of("Water", 50, "Coffee", 20, "Milk", 40)));
  }

  public void addRecipe(String recipeName, Double price, Map<String, Integer> ingredients) {
    recipes.put(recipeName, new CoffeeRecipe(recipeName, price, ingredients));
  }

  public CoffeeRecipe selectRecipe(String recipeName) {
    if (recipes.containsKey(recipeName)) {
      return recipes.get(recipeName);
    } else {
      throw new RuntimeException("Coffee does not exits - " + recipeName);
    }
  }

  public void dispenceCoffee(CoffeeRecipe recipeName, Payment payment) {
    if (!inventory.hasEnoughIngredients(recipeName.getIngredients())) {
      throw new RuntimeException("Insufficient ingredients to make " + recipeName.getName());
    }
    if (payment.getAmmount() < recipeName.getPrice()) {
      throw new RuntimeException("Insufficient money , required - " + recipeName.getPrice());
    }
    inventory.consume(recipeName.getIngredients());
    dispenser.prepareDrink(recipeName);

    double change = paymentProcessor.processPayment(recipeName.getPrice(), payment.getAmmount());

    if (change > 0) {
      System.out.println("Please collect your change: $" + change);
    }
  }

  public void refillIngredient(String ingredient, int quantity) {
    inventory.refill(ingredient, quantity);
  }

  public void showIngredients() {
    System.out.println("Ingredient Levels:");
    inventory.getInventory().forEach((k, v) -> System.out.println(k + ": " + v));
  }
}
