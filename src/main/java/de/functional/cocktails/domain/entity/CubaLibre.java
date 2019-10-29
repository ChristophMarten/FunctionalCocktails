package de.functional.cocktails.domain.entity;

import java.util.List;

public class CubaLibre {

  public static final int INGREDIENT_AMOUNT_FOR_CUBALIBRE = 5;
  private final List<Ingredient> ingredients = List.of(new Ingredient("Glass"), new Ingredient("Coke"), new Ingredient("Ice"), new Ingredient("Rum"), new Ingredient("Lime"));

  public static final int GLASS_AMOUNT_FOR_RECIPE = 1;

  public static final int COKE_AMOUNT_FOR_RECIPE = 350;

  public static final int ICE_AMOUNT_FOR_RECIPE = 3;

  public static final int RUM_AMOUNT_FOR_RECIPE = 8;

  public static final int LIME_AMOUNT_FOR_RECIPE = 1;

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
