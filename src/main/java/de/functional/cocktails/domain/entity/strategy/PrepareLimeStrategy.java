package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class PrepareLimeStrategy {

  public PrepareIngredients prepareLime = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + " Cuted " +ingredientName);
      System.out.println(amount + " Pressed " + ingredientName);
      System.out.println(amount + " poured " + ingredientName );
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough "+ingredientName);
    }
  };
}
