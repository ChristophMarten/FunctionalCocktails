package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class PrepareSugarStrategy {

  public PrepareIngredients prepareSugar = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName + " added !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough " + ingredientName);
    }
  };
}
