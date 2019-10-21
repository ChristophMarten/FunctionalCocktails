package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class Ingredient {

  private final String name;

  public Ingredient(String name) {
    this.name = name;
    }

  public boolean prepare(int amount,int minmalAmountForRecipe, HandleIngredients hI, String ingredientName) throws NotEnoughItemsFromIngredient {
    return hI.prepare(amount, minmalAmountForRecipe,ingredientName);
  }

  public String getName() {
    return name;
  }
}
