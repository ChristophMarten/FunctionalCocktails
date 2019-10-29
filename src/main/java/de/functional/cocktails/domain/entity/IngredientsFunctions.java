package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.exception.NotEnoughIngredientsForCocktail;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class IngredientsFunctions {

  private IngredientsFunctions() {

  }

  public static final PrepareIngredients prepareIngredient = (preparingType, amount, minmalAmountForRecipe, ingredientName) -> {
    if (amount >= minmalAmountForRecipe) {
      System.out.println(minmalAmountForRecipe + " " + ingredientName + " " + preparingType.getSysOutText());
      return true;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough " + ingredientName);
    }
  };

  public static boolean enoughIngredients(IntPredicate p, List<Ingredient> ingredients) throws NotEnoughIngredientsForCocktail {
    if (p.test(ingredients.size())) {
      System.out.println("Sufficient ingredients available");
      return true;
    } else {
      throw new NotEnoughIngredientsForCocktail("Not enough ingredients available");
    }
  }

  public static void logIsIngredientPrepared(String ingredientName, List<Ingredient> ingredients) {
    Predicate<Ingredient> namePredicate = i -> (i.getName().equals(ingredientName));
    ingredients.stream()
        .filter(namePredicate)
        .map(i -> i.getName() + " isPrepared = " + i.isPrepared())
        .forEach(System.out::println);
  }
}
