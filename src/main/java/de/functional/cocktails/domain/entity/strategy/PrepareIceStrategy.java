package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class PrepareIceStrategy {

  public PrepareIngredients prepareIce = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName +" Crushed !");
      System.out.println(amount + ingredientName + " poured !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("No enough " + ingredientName);
    }
  };
}
