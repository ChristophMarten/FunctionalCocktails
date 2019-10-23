package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Ingredient;
import de.functional.cocktails.domain.entity.Mojito;
import de.functional.cocktails.domain.entity.PrepareIngredientsFunctions;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;
import java.util.List;
import java.util.stream.Collectors;

public class MojitoMixService {

  public Mojito mixMojito(int amountOfGlass, int amountOfRum, int amountOfSoda, int amountOfLime, int amountOfIce, int amountOfBrownSugar, int amountOfMint) throws NotEnoughItemsFromIngredient {
    Mojito mojito = new Mojito();

    List<Ingredient> ingredients = mojito.getIngredients();
    Ingredient glass = ingredients.get(0);
    glass.prepare(PreparingType.WASH, amountOfGlass, mojito.getGlassAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient rum = ingredients.get(1);
    rum.prepare(PreparingType.POUR, amountOfRum, mojito.getRumAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient soda = ingredients.get(2);
    soda.prepare(PreparingType.POUR, amountOfSoda, mojito.getSodaAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient lime = ingredients.get(3);
    lime.prepare(PreparingType.CUT, amountOfLime, mojito.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.PRESS, amountOfLime, mojito.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.ADD, amountOfLime, mojito.getLimeAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient ice = ingredients.get(4);
    ice.prepare(PreparingType.CRUSH, amountOfIce, mojito.getIceAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    ice.prepare(PreparingType.POUR, amountOfIce, mojito.getIceAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient brownSugar = ingredients.get(5);
    brownSugar.prepare(PreparingType.POUR, amountOfBrownSugar, mojito.getBrownSugarAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    Ingredient mint = ingredients.get(6);
    mint.prepare(PreparingType.CUT, amountOfMint, mojito.getMintAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    mint.prepare(PreparingType.CRUSH, amountOfMint, mojito.getMintAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);
    mint.prepare(PreparingType.ADD, amountOfMint, mojito.getMintAmountForRecipe(), PrepareIngredientsFunctions.prepareIngredient);

    shaking(ingredients);

    mojito.setReadyToDrink(true);
    System.out.println("Mojito ready :) ");

    return mojito;
  }

  private void shaking(List<Ingredient> ingredients) {
    String result = ingredients.stream()
        .map(i -> i.getName())
        .collect(Collectors.joining("-", "{", " shaked !}"));

    System.out.println(result);
  }


}
