package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.entity.HandleIngredients;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public interface PrepareSodaStrategy {

  HandleIngredients prepareSoda = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName + " poured !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough " + ingredientName);
    }
  };
}
