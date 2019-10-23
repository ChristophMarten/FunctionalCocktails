package de.functional.cocktails.domain.entity;

import java.util.List;

public class CubaLibre {

  private final List<Ingredient> ingredients = List.of(new Ingredient("Glass"), new Ingredient("Coke"), new Ingredient("Ice"), new Ingredient("Rum"), new Ingredient("Lime"));

  private final int glassAmountForRecipe = 1;

  private final int cokeAmountForRecipe = 350;

  private final int iceAmountForRecipe = 3;

  private final int rumAmountForRecipe = 8;

  private final int limeAmountForRecipe = 1;

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public  int getGlassAmountForRecipe() {
    return glassAmountForRecipe;
  }

  public int getCokeAmountForRecipe() {
    return cokeAmountForRecipe;
  }

  public int getIceAmountForRecipe() {
    return iceAmountForRecipe;
  }

  public int getRumAmountForRecipe() {
    return rumAmountForRecipe;
  }

  public int getLimeAmountForRecipe() {
    return limeAmountForRecipe;
  }


}
