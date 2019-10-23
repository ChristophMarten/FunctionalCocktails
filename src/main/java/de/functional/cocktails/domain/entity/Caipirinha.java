package de.functional.cocktails.domain.entity;

import java.util.List;

public class Caipirinha {

  private final List<Ingredient> ingredients = List.of(new Ingredient("Glass"), new Ingredient("Cachaca"), new Ingredient("Ice"), new Ingredient("BrownSugar"), new Ingredient("Lime"));

  private final int glassAmountForRecipe = 1;

  private final int cachacaAmountForRecipe = 6;

  private final int iceAmountForRecipe = 5;

  private final int brownSugarAmountForRecipe = 2;

  private final int limeAmountForRecipe = 1;

  private boolean readyToDrink = false;

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public int getGlassAmountForRecipe() {
    return glassAmountForRecipe;
  }

  public int getCachacaAmountForRecipe() {
    return cachacaAmountForRecipe;
  }

  public int getIceAmountForRecipe() {
    return iceAmountForRecipe;
  }

  public int getBrownSugarAmountForRecipe() {
    return brownSugarAmountForRecipe;
  }

  public int getLimeAmountForRecipe() {
    return limeAmountForRecipe;
  }

  public boolean isReadyToDrink() {
    return readyToDrink;
  }

  public void setReadyToDrink(boolean readyToDrink) {
    this.readyToDrink = readyToDrink;
  }
}
