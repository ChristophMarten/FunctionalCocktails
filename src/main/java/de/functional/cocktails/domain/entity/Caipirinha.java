package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.entity.strategy.PrepareCachacaStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareGlassStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareIceStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareLimeStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareSugarStrategy;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import java.util.List;

public class Caipirinha {

  private final List<Ingredient> ingredients = List.of(new Ingredient("Glass"), new Ingredient("Cachaca"), new Ingredient("Ice"), new Ingredient("BrownSugar"), new Ingredient("Lime"));

  private final static int glassAmountForRecipe = 1;

  private final static int cachacaAmountForRecipe = 6;

  private final static int iceAmountForRecipe = 5;

  private final static int brownSugarAmountForRecipe = 2;

  private final static int limeAmountForRecipe = 1;

  private Caipirinha() {
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public static Caipirinha createInstance(int amountOfGlass, int amountOfCachaca, int amountOfIce, int amountOfBrownSugar, int amountOfLime) throws NotEnoughItemsFromIngredient {
    Caipirinha caipirinha = new Caipirinha();

    List<Ingredient> ingredients = caipirinha.getIngredients();
    ingredients.get(0).prepare(amountOfGlass, glassAmountForRecipe, PrepareGlassStrategy.prepareGlass, ingredients.get(0).getName());
    ingredients.get(2).prepare(amountOfIce, iceAmountForRecipe, PrepareIceStrategy.prepareIce, ingredients.get(2).getName());
    ingredients.get(3).prepare(amountOfBrownSugar, brownSugarAmountForRecipe, PrepareSugarStrategy.prepareSugar, ingredients.get(3).getName());
    ingredients.get(4).prepare(amountOfLime, limeAmountForRecipe, PrepareLimeStrategy.prepareLime, ingredients.get(4).getName());

    return caipirinha;
  }

}
