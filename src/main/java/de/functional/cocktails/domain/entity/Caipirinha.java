package de.functional.cocktails.domain.entity;

import java.util.List;

public class Caipirinha {

  private final List<Ingredient> ingredients = List.of(new Ingredient("Glass"), new Ingredient("Cachaca"), new Ingredient("Ice"), new Ingredient("BrownSugar"), new Ingredient("Lime"));

  public static final int GLASS_AMOUNT_FOR_RECIPE = 1;

  public static final int CACHACA_AMOUNT_FOR_RECIPE = 6;

  public static final int ICE_AMOUNT_FOR_RECIPE = 5;

  public static final int BROWN_SUGAR_AMOUNT_FOR_RECIPE = 2;

  public static final int LIME_AMOUNT_FOR_RECIPE = 1;

  public static final int INGREDIENT_AMOUNT_FOR_CAIPIRINHA = 5;

  private boolean readyToDrink = false;

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public boolean isReadyToDrink() {
    return readyToDrink;
  }

  public void setReadyToDrink(boolean readyToDrink) {
    this.readyToDrink = readyToDrink;
  }

}
