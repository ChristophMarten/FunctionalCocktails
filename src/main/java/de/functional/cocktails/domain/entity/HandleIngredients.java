package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

@FunctionalInterface
public interface HandleIngredients {

  boolean prepare(int amount, int minmalAmountForRecipe, String ingredientName) throws NotEnoughItemsFromIngredient;

}
