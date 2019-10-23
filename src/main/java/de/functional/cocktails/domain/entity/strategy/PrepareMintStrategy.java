package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class PrepareMintStrategy {

  public PrepareIngredients prepareMint = (amount, minmalAmountForRecipe, ingredientName) -> {

    if (amount <= minmalAmountForRecipe) {
      System.out.println(amount + ingredientName + " crushed !");
      System.out.println(amount + ingredientName + " added !");
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough " + ingredientName);
    }
  };}

