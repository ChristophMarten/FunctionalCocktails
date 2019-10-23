package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;

public class Ingredient {

  private final String name;

  private boolean prepared;

  public Ingredient(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void prepare(PreparingType preparingType,int amount, int minmalAmountForRecipe, PrepareIngredients pI) throws NotEnoughItemsFromIngredient {
    prepared = pI.prepare(preparingType, amount, minmalAmountForRecipe, name);
  }

  public boolean isPrepared() {
    return prepared;
  }
}
