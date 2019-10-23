package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class PrepareRumStrategy {

  public PrepareIngredients prepareRum = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName +" poured !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough" +ingredientName);
    }
  };
}
