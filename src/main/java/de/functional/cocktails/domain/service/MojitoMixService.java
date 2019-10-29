package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Ingredient;
import de.functional.cocktails.domain.entity.IngredientsFunctions;
import de.functional.cocktails.domain.entity.Mojito;
import de.functional.cocktails.domain.exception.NotEnoughIngredientsForCocktail;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class MojitoMixService {

  public Mojito mixMojito(int amountOfGlass, int amountOfRum, int amountOfSoda, int amountOfLime, int amountOfIce, int amountOfBrownSugar, int amountOfMint)
      throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {
    Mojito mojito = new Mojito();

    List<Ingredient> ingredients = mojito.getIngredients();
    Ingredient glass = ingredients.get(0);

    IntPredicate pred = iS -> iS == Mojito.INGREDIENT_AMOUNT_FOR_MOJITO;
    IngredientsFunctions.enoughIngredients(pred, ingredients);

    glass.prepare(PreparingType.WASH, amountOfGlass, Mojito.GLASS_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient rum = ingredients.get(1);
    rum.prepare(PreparingType.POUR, amountOfRum, Mojito.RUM_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient soda = ingredients.get(2);
    soda.prepare(PreparingType.POUR, amountOfSoda, Mojito.SODA_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient lime = ingredients.get(3);
    lime.prepare(PreparingType.CUT, amountOfLime, Mojito.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.PRESS, amountOfLime, Mojito.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    lime.prepare(PreparingType.ADD, amountOfLime, Mojito.LIME_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient ice = ingredients.get(4);
    ice.prepare(PreparingType.CRUSH, amountOfIce, Mojito.ICE_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    ice.prepare(PreparingType.POUR, amountOfIce, Mojito.ICE_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient brownSugar = ingredients.get(5);
    brownSugar.prepare(PreparingType.POUR, amountOfBrownSugar, Mojito.BROWN_SUGAR_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    Ingredient mint = ingredients.get(6);
    mint.prepare(PreparingType.CUT, amountOfMint, Mojito.MINT_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    mint.prepare(PreparingType.CRUSH, amountOfMint, Mojito.MINT_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);
    mint.prepare(PreparingType.ADD, amountOfMint, Mojito.MINT_AMOUNT_FOR_RECIPE, IngredientsFunctions.prepareIngredient);

    IngredientsFunctions.logIsIngredientPrepared(mint.getName(), ingredients);

    shaking(ingredients);

    mojito.setReadyToDrink(true);
    System.out.println("Mojito ready :) ");

    return mojito;
  }

  private void shaking(List<Ingredient> ingredients) {
    String result = ingredients.stream()
        .map(Ingredient::getName)
        .collect(Collectors.joining("-", "{", " shaked !}"));

    System.out.println(result);
  }


}
