package de.functional.cocktails.domain.entity;

import java.util.List;

public class CubaLibre {

  private final List<Ingredient> ingredients = List.of(new Ingredient("Cola"), new Ingredient("Ice"), new Ingredient("Rum"), new Ingredient("Lime"));

  public CubaLibre() {
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

}
