package de.functional.cocktails.domain.entity;

import java.util.List;

public class Mojito {

  public static final int INGREDIENT_AMOUNT_FOR_MOJITO = 7;

  private final List<Ingredient> ingredients = List
      .of(new Ingredient("Glass"), new Ingredient("Rum"), new Ingredient("Soda"), new Ingredient("Lime"), new Ingredient("Ice"), new Ingredient("Brown Sugar"), new Ingredient("Mint"));

  public static final int GLASS_AMOUNT_FOR_RECIPE = 1;

  public static final int RUM_AMOUNT_FOR_RECIPE = 5;

  public static final int SODA_AMOUNT_FOR_RECIPE = 6;

  public static final int LIME_AMOUNT_FOR_RECIPE = 1;

  public static final int ICE_AMOUNT_FOR_RECIPE = 4;

  public static final int BROWN_SUGAR_AMOUNT_FOR_RECIPE = 2;

  public static final int MINT_AMOUNT_FOR_RECIPE = 8;

  private boolean isReadyToDrink = false;

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public boolean isReadyToDrink() {
    return isReadyToDrink;
  }

  public void setReadyToDrink(boolean readyToDrink) {
    isReadyToDrink = readyToDrink;
  }
}
