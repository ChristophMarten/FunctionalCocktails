package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.entity.strategy.PrepareGlassStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareIceStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareLimeStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareMintStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareRumStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareSodaStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareSugarStrategy;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import java.util.List;

public class Mojito  {

  private final List<Ingredient> ingredients = List.of(new Ingredient("Glass"), new Ingredient("Rum"), new Ingredient("Soda"), new Ingredient("Lime"), new Ingredient("Ice"), new Ingredient("Brown Sugar"), new Ingredient("Mint"));

  private final static int glassAmountForRecipe = 1;

  private final static int rumAmountForRecipe = 5;

  private final static int sodaAmountForRecipe = 6;

  private final static int limeAmountForRecipe = 1;

  private final static int iceAmountForRecipe = 4;

  private final static int brownSugarAmountForRecipe = 2;

  private final static int mintAmountForRecipe = 8;

  private Mojito() {
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public static Mojito createInstance(int amountOfGlass, int amountOfRum, int amountOfSoda, int amountOfLime, int amountOfIce, int amountOfBrownSugar, int amountOfMint) throws NotEnoughItemsFromIngredient {
    Mojito mojito = new Mojito();
    List<Ingredient> ingredients = mojito.getIngredients();
    ingredients.get(0).prepare(amountOfGlass, glassAmountForRecipe, PrepareGlassStrategy.prepareGlassWithUmbrella, ingredients.get(0).getName());
    ingredients.get(1).prepare(amountOfRum, rumAmountForRecipe, PrepareRumStrategy.prepareRum, ingredients.get(1).getName());
    ingredients.get(2).prepare(amountOfSoda, sodaAmountForRecipe, PrepareSodaStrategy.prepareSoda, ingredients.get(2).getName());
    ingredients.get(3).prepare(amountOfLime, limeAmountForRecipe, PrepareLimeStrategy.prepareLime, ingredients.get(3).getName());
    ingredients.get(4).prepare(amountOfIce, iceAmountForRecipe, PrepareIceStrategy.prepareIce, ingredients.get(4).getName());
    ingredients.get(5).prepare(amountOfBrownSugar, brownSugarAmountForRecipe, PrepareSugarStrategy.prepareSugar, ingredients.get(5).getName());
    ingredients.get(6).prepare(amountOfMint, mintAmountForRecipe, PrepareMintStrategy.prepareMint, ingredients.get(6).getName());

    return mojito;
  }

}
