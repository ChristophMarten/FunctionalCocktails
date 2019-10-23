package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.CubaLibre;
import de.functional.cocktails.domain.entity.Ingredient;
import de.functional.cocktails.domain.entity.PrepareIngredientsFunctions;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;
import java.util.List;
import java.util.stream.Collectors;

public class CubaLibreMixService {

  public CubaLibre mixCubaLibre(int amountOfGlass, int amountOfCoke, int amountOfIce, int amountOfRum, int amountOfLime) throws NotEnoughItemsFromIngredient {
    CubaLibre cubaLibre = new CubaLibre();
    List<Ingredient> ingredients = cubaLibre.getIngredients();
    Ingredient glass = ingredients.get(0);
    glass.prepare(PreparingType.WASH, amountOfGlass, cubaLibre.getGlassAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient coke = ingredients.get(1);
    coke.prepare(PreparingType.POUR, amountOfCoke, cubaLibre.getCokeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient ice = ingredients.get(2);
    ice.prepare(PreparingType.CRUSH, amountOfIce, cubaLibre.getIceAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    ice.prepare(PreparingType.POUR, amountOfIce, cubaLibre.getIceAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient rum = ingredients.get(3);
    rum.prepare(PreparingType.POUR, amountOfRum, cubaLibre.getRumAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient lime = ingredients.get(4);
    lime.prepare(PreparingType.CUT, amountOfLime, cubaLibre.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.PRESS, amountOfLime, cubaLibre.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.ADD, amountOfLime, cubaLibre.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    shaking(ingredients);

    cubaLibre.setReadyToDrink(true);
    System.out.println("Cuba Libre ready :) ");

    return cubaLibre;
  }


  private void shaking(List<Ingredient> ingredients) {
    String result = ingredients.stream()
        .map(i -> i.getName())
        .collect(Collectors.joining("-", "{", " shaked !}"));

    System.out.println(result);
  }

}
