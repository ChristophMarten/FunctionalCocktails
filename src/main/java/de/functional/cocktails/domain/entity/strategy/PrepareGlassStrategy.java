package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.entity.HandleIngredients;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public interface PrepareGlassStrategy {

  HandleIngredients prepareGlass = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName + " washed !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("No " + ingredientName + " found");
    }
  };

  HandleIngredients prepareGlassWithUmbrella = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName + " washed !");
      System.out.println("add fancy umbrella");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("No " + ingredientName + " found");
    }

  };
}
