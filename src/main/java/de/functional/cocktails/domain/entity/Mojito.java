package de.functional.cocktails.domain.entity;

import java.util.List;

public class Mojito {

  private final List<Ingredient> ingredients = List
      .of(new Ingredient("Glass"), new Ingredient("Rum"), new Ingredient("Soda"), new Ingredient("Lime"), new Ingredient("Ice"), new Ingredient("Brown Sugar"), new Ingredient("Mint"));

  private final int glassAmountForRecipe = 1;

  private final int rumAmountForRecipe = 5;

  private final int sodaAmountForRecipe = 6;

  private final int limeAmountForRecipe = 1;

  private final int iceAmountForRecipe = 4;

  private final int brownSugarAmountForRecipe = 2;

  private final int mintAmountForRecipe = 8;

  private boolean isReadyToDrink = false;

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public int getGlassAmountForRecipe() {
    return glassAmountForRecipe;
  }

  public int getRumAmountForRecipe() {
    return rumAmountForRecipe;
  }

  public int getSodaAmountForRecipe() {
    return sodaAmountForRecipe;
  }

  public int getLimeAmountForRecipe() {
    return limeAmountForRecipe;
  }

  public int getIceAmountForRecipe() {
    return iceAmountForRecipe;
  }

  public int getBrownSugarAmountForRecipe() {
    return brownSugarAmountForRecipe;
  }

  public int getMintAmountForRecipe() {
    return mintAmountForRecipe;
  }

  public boolean isReadyToDrink() {
    return isReadyToDrink;
  }

  public void setReadyToDrink(boolean readyToDrink) {
    isReadyToDrink = readyToDrink;
  }
}
