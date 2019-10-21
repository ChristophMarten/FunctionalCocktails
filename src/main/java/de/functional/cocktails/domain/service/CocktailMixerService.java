package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Caipirinha;
import de.functional.cocktails.domain.entity.CubaLibre;
import de.functional.cocktails.domain.entity.Mojito;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;

public class CocktailMixerService {

  public CubaLibre mixCubaLibre(int amoutOfGlass, int amountOfCoke, int amountOfIce, int amountOfRum, int amountOfLime) throws NotEnoughItemsFromIngredient {
    return CubaLibre.createInstance(amoutOfGlass, amountOfCoke, amountOfIce, amountOfRum, amountOfLime);
  }

  public Caipirinha mixCaipirinha(int amountOfGlass, int amountOfCachaca, int amountOfIce, int amountOfBrownSugar, int amountOfLime) throws NotEnoughItemsFromIngredient {

    return Caipirinha.createInstance( amountOfGlass,  amountOfCachaca,  amountOfIce,  amountOfBrownSugar,  amountOfLime);
  }

  public Mojito mixMojito(int amountOfGlass, int amountOfRum, int amountOfSoda, int amountOfLime, int amountOfIce, int amountOfBrownSugar, int amountOfMint) throws NotEnoughItemsFromIngredient {

    return Mojito.createInstance(amountOfGlass, amountOfRum, amountOfSoda, amountOfLime, amountOfIce, amountOfBrownSugar, amountOfMint);
  }

}
