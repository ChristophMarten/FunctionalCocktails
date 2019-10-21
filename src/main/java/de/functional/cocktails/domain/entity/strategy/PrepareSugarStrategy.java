package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.entity.HandleIngredients;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public interface PrepareSugarStrategy {

  HandleIngredients prepareSugar = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName + " added !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough " + ingredientName);
    }
  };
}
