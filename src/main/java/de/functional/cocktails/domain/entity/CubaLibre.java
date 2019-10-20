package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.entity.strategy.PrepareCokeStrategy;
import java.util.List;

public class CubaLibre implements PrepareCokeStrategy {

  private final List<Ingredient> ingredients = List.of(new Ingredient("Cola"), new Ingredient("Ice"), new Ingredient("Rum"), new Ingredient("Lime"));

  private final int amountOfCoke = 350;

  private final int amountOfLime = 1;

  private final int amountOfIce = 3;

  private final int amountOfRum = 8;

  public CubaLibre() {
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

// public HandleIngredients prepareCoke = (a)-> {if (a <= amountOfCoke){
//    System.out.println(a+" Coke poured !");
//    return true;
//  }else{
//    System.out.println("Not enough Coke");
//    return false;
//  }
//};


}
