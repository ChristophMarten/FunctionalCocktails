package de.functional.cocktails.domain.exception;

public class NotEnoughIngredientsForCocktail extends Exception {

  public NotEnoughIngredientsForCocktail(String message) {
    super(message);
  }

}
