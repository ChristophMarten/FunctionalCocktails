package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class PrepareGlassStrategy {

  public PrepareIngredients prepareGlass = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName + " washed !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("No " + ingredientName + " found");
    }
  };

  public PrepareIngredients prepareGlassWithUmbrella = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName + " washed !");
      System.out.println("add fancy umbrella");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("No " + ingredientName + " found");
    }

  };
}
