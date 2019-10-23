package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Caipirinha;
import de.functional.cocktails.domain.entity.Ingredient;
import de.functional.cocktails.domain.entity.PrepareIngredientsFunctions;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;
import java.util.List;
import java.util.stream.Collectors;

public class CaipirinhaMixService {

  public Caipirinha mixCaipirinha(int amountOfGlass, int amountOfCachaca, int amountOfIce, int amountOfBrownSugar, int amountOfLime) throws NotEnoughItemsFromIngredient {
    Caipirinha caipirinha = new Caipirinha();

    List<Ingredient> ingredients = caipirinha.getIngredients();
    Ingredient glass = ingredients.get(0);
    glass.prepare(PreparingType.WASH, amountOfGlass, caipirinha.getGlassAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient coke = ingredients.get(1);
    coke.prepare(PreparingType.POUR, amountOfCachaca, caipirinha.getCachacaAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient ice = ingredients.get(2);
    ice.prepare(PreparingType.CRUSH, amountOfIce, caipirinha.getIceAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    ice.prepare(PreparingType.POUR, amountOfIce, caipirinha.getIceAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient rum = ingredients.get(3);
    rum.prepare(PreparingType.POUR, amountOfBrownSugar, caipirinha.getBrownSugarAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient lime = ingredients.get(4);
    lime.prepare(PreparingType.CUT, amountOfLime, caipirinha.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.PRESS, amountOfLime, caipirinha.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.ADD, amountOfLime, caipirinha.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    shaking(ingredients);

    caipirinha.setReadyToDrink(true);
    System.out.println("Caipirinha ready :) ");

    return caipirinha;
  }


  private void shaking(List<Ingredient> ingredients) {
    String result = ingredients.stream()
        .map(i -> i.getName())
        .collect(Collectors.joining("-", "{", " shaked !}"));

    System.out.println(result);
  }


}
