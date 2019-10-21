package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.entity.HandleIngredients;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public interface PrepareLimeStrategy {

  HandleIngredients prepareLime = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + " Cut " +ingredientName);
      System.out.println(amount + " Press " + ingredientName);
      System.out.println(amount + ingredientName + " poured !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough "+ingredientName);
    }
  };
}
