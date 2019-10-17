package de.functional.cocktails.domain.exception;

public class NotEnoughItemsFromIngredient extends Exception {

  public NotEnoughItemsFromIngredient(String message) {
    super(message);
  }

}
