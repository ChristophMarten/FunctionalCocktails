package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Caipirinha;
import de.functional.cocktails.domain.entity.Ingredient;
import de.functional.cocktails.domain.entity.IngredientsFunctions;
import de.functional.cocktails.domain.exception.NotEnoughIngredientsForCocktail;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class CaipirinhaMixService {

  public Caipirinha mixCaipirinha(int amountOfGlass, int amountOfCachaca, int amountOfIce, int amountOfBrownSugar, int amountOfLime)
      throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {
    Caipirinha caipirinha = new Caipirinha();

    List<Ingredient> ingredients = caipirinha.getIngredients();
    IntPredicate pred = iS -> iS == Caipirinha.INGREDIENT_AMOUNT_FOR_CAIPIRINHA;

    IngredientsFunctions.enoughIngredients(pred, ingredients);

    Ingredient glass = ingredients.get(0);
    glass.prepare(PreparingType.WASH, amountOfGlass, Caipirinha.GLASS_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient coke = ingredients.get(1);
    coke.prepare(PreparingType.POUR, amountOfCachaca, Caipirinha.CACHACA_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient ice = ingredients.get(2);
    ice.prepare(PreparingType.CRUSH, amountOfIce, Caipirinha.ICE_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    ice.prepare(PreparingType.POUR, amountOfIce, Caipirinha.ICE_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient rum = ingredients.get(3);
    rum.prepare(PreparingType.POUR, amountOfBrownSugar, Caipirinha.BROWN_SUGAR_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient lime = ingredients.get(4);
    lime.prepare(PreparingType.CUT, amountOfLime, Caipirinha.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.PRESS, amountOfLime, Caipirinha.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.ADD, amountOfLime, Caipirinha.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    IngredientsFunctions.logIsIngredientPrepared(lime.getName(), ingredients);

    shaking(ingredients);

    caipirinha.setReadyToDrink(true);
    System.out.println("Caipirinha ready :) ");

    return caipirinha;
  }

  private void shaking(List<Ingredient> ingredients) {
    String result = ingredients.stream()
        .map(Ingredient::getName)
        .collect(Collectors.joining("-", "{", " shaked !}"));

    System.out.println(result);
  }

}
