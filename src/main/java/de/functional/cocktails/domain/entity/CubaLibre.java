package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.entity.strategy.PrepareCokeStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareGlassStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareIceStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareLimeStrategy;
import de.functional.cocktails.domain.entity.strategy.PrepareRumStrategy;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import java.util.List;

public class CubaLibre{

  private final List<Ingredient> ingredients = List.of(new Ingredient("Glass"), new Ingredient("Coke"), new Ingredient("Ice"), new Ingredient("Rum"), new Ingredient("Lime"));

  private final static int glassAmountForRecipe = 1;

  private final static int cokeAmountForRecipe = 350;

  private final static int iceAmountForRecipe = 3;

  private final static int rumAmountForRecipe = 8;

  private final static int limeAmountForRecipe = 1;

  private CubaLibre() {
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public static CubaLibre createInstance(int amountOfGlass, int amountOfCoke, int amountOfIce, int amountOfRum, int amountOfLime) throws NotEnoughItemsFromIngredient {
    CubaLibre cubaLibre = new CubaLibre();
    List<Ingredient> ingredients = cubaLibre.getIngredients();
    ingredients.get(0).prepare(amountOfGlass, glassAmountForRecipe, PrepareGlassStrategy.prepareGlass, ingredients.get(0).getName());
    ingredients.get(1).prepare(amountOfCoke, cokeAmountForRecipe, PrepareCokeStrategy.prepareCoke, ingredients.get(1).getName());
    ingredients.get(2).prepare(amountOfIce, iceAmountForRecipe, PrepareIceStrategy.prepareIce, ingredients.get(2).getName());
    ingredients.get(3).prepare(amountOfRum, rumAmountForRecipe, PrepareRumStrategy.prepareRum, ingredients.get(3).getName());
    ingredients.get(4).prepare(amountOfLime, limeAmountForRecipe, PrepareLimeStrategy.prepareLime, ingredients.get(4).getName());

    return cubaLibre;
  }

}
