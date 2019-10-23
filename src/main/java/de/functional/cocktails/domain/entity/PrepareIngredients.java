package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;

@FunctionalInterface
public interface PrepareIngredients {

  boolean prepare(PreparingType preparingType, int amount, int minmalAmountForRecipe, String ingredientName) throws NotEnoughItemsFromIngredient;

}
