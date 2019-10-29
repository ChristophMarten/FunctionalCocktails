package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.CubaLibre;
import de.functional.cocktails.domain.entity.Ingredient;
import de.functional.cocktails.domain.entity.IngredientsFunctions;
import de.functional.cocktails.domain.exception.NotEnoughIngredientsForCocktail;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class CubaLibreMixService {

  public CubaLibre mixCubaLibre(int amountOfGlass, int amountOfCoke, int amountOfIce, int amountOfRum, int amountOfLime) throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {
    CubaLibre cubaLibre = new CubaLibre();
    List<Ingredient> ingredients = cubaLibre.getIngredients();

    IntPredicate pred = iS -> iS == CubaLibre.INGREDIENT_AMOUNT_FOR_CUBALIBRE;
    IngredientsFunctions.enoughIngredients(pred, ingredients);

    Ingredient glass = ingredients.get(0);
    glass.prepare(PreparingType.WASH, amountOfGlass, CubaLibre.GLASS_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient coke = ingredients.get(1);
    coke.prepare(PreparingType.POUR, amountOfCoke, CubaLibre.COKE_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient ice = ingredients.get(2);
    ice.prepare(PreparingType.CRUSH, amountOfIce, CubaLibre.ICE_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    ice.prepare(PreparingType.POUR, amountOfIce, CubaLibre.ICE_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    IngredientsFunctions.logIsIngredientPrepared(ice.getName(), ingredients);

    Ingredient rum = ingredients.get(3);
    rum.prepare(PreparingType.POUR, amountOfRum, CubaLibre.RUM_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient lime = ingredients.get(4);
    lime.prepare(PreparingType.CUT, amountOfLime, CubaLibre.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.PRESS, amountOfLime, CubaLibre.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.ADD, amountOfLime, CubaLibre.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    shaking(ingredients);

    cubaLibre.setReadyToDrink(true);
    System.out.println("Cuba Libre ready :) ");

    return cubaLibre;
  }


  private void shaking(List<Ingredient> ingredients) {
    String result = ingredients.stream()
        .map(Ingredient::getName)
        .collect(Collectors.joining("-", "{", " shaked !}"));

    System.out.println(result);
  }

}
