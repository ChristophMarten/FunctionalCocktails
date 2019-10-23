package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

@FunctionalInterface
public interface PrepareIngredients {

  boolean prepare(int amount, int minmalAmountForRecipe, String ingredientName) throws NotEnoughItemsFromIngredient;

}
