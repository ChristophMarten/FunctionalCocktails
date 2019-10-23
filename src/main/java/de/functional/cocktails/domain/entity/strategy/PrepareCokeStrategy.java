package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class PrepareCokeStrategy {

  public PrepareIngredients prepareCoke = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName +" poured !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough " +ingredientName);
    }
  };
}
