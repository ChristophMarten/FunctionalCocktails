package de.functional.cocktails.domain.entity;

@FunctionalInterface
public interface HandleIngredients {

  boolean prepare(int amount);

}
