package com.lld.traffic_signal_system;

public class App {
  public static void main(String[] args) {

    CoffeeVendingMachine machine = CoffeeVendingMachine.getInstance();
    // use default recipes
    CoffeeRecipe coffeeRecipe = machine.selectRecipe("Espresso");
    Payment payment = new Payment(20);

    machine.refillIngredient("Water", 120);
    machine.refillIngredient("Milk", 70);
    machine.refillIngredient("Coffee", 150);

    machine.showIngredients();
    machine.dispenceCoffee(coffeeRecipe, payment);
    machine.showIngredients();

  }
}
