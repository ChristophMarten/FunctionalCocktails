package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Caipirinha;
import de.functional.cocktails.domain.exception.NotEnoughIngredientsForCocktail;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CaipirinhaMixServiceTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
  private CaipirinhaMixService caipirinhaMixService;
  private Caipirinha caipirinha;

  @Before
  public void setUp() {
    caipirinhaMixService = new CaipirinhaMixService();
    caipirinha = new Caipirinha();
  }

  @Test
  public void testMixCaipirinha() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {
    caipirinha = caipirinhaMixService.mixCaipirinha(555, 555, 555, 555, 555);
    Assert.assertTrue(!caipirinha.isReadyToDrink());
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughGlass() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Glass");

    caipirinhaMixService.mixCaipirinha(Caipirinha.GLASS_AMOUNT_FOR_RECIPE - 1, 500, 500, 500, 500);
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughCachaca() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Cachaca");

    caipirinhaMixService.mixCaipirinha(500, Caipirinha.CACHACA_AMOUNT_FOR_RECIPE - 1, 500, 500, 500);
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughIce() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Ice");

    caipirinhaMixService.mixCaipirinha(500, 500, Caipirinha.ICE_AMOUNT_FOR_RECIPE - 1, 500, 500);
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughRum() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough BrownSugar");

    caipirinhaMixService.mixCaipirinha(500, 500, 500, Caipirinha.BROWN_SUGAR_AMOUNT_FOR_RECIPE - 1, 500);
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughLime() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Lime");

    caipirinhaMixService.mixCaipirinha(500, 500, 500, 500, Caipirinha.LIME_AMOUNT_FOR_RECIPE - 1);
  }

}
