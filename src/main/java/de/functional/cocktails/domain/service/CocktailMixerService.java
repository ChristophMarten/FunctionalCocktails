package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Caipirinha;
import de.functional.cocktails.domain.entity.CubaLibre;
import de.functional.cocktails.domain.entity.HandleIngredients;
import de.functional.cocktails.domain.entity.Ingredient;
import de.functional.cocktails.domain.entity.Mojito;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import java.util.List;

public class CocktailMixerService {

  public CubaLibre mixCubaLibre() throws NotEnoughItemsFromIngredient {

    CubaLibre cubaLibre = new CubaLibre();

    List<Ingredient> ingredients = cubaLibre.getIngredients();

    final int amountFinal = 10;

    HandleIngredients hI = (amount) -> {
      if (amount <= amountFinal) {
        return true;
      } else {
        return false;
      }
    };

    boolean erfolg = ingredients.get(0).prepare(11, hI);

    if (erfolg) {
      return cubaLibre;
    } else {
      throw new NotEnoughItemsFromIngredient("Not enough Items from " + ingredients.get(0).getName());
    }

  }

  public Caipirinha mixCaipirinha() {

    return null;
  }

  public Mojito mixMojito() {

    return null;
  }

}
