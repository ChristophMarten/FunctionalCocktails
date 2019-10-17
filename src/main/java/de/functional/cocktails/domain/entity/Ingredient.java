package de.functional.cocktails.domain.entity;

public class Ingredient {

  private final String name;

  public Ingredient(String name) {
    this.name = name;
    }

  public boolean prepare(int amount, HandleIngredients hI) {
    return hI.prepare(amount);
  }

  public String getName() {
    return name;
  }
}
