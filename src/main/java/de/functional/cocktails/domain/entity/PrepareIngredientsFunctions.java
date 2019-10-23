package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class PrepareIngredientsFunctions {

  private PrepareIngredientsFunctions() {

  }

  public static final PrepareIngredients prepareIngredient = (preparingType, amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount >= minmalAmountForRecipe) {
      System.out.println(minmalAmountForRecipe + " " + ingredientName + " " + preparingType.getSysOutText());
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough " + ingredientName);
    }
  };

}
