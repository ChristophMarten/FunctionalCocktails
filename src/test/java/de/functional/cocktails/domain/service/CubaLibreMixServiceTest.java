package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.CubaLibre;
import de.functional.cocktails.domain.exception.NotEnoughIngredientsForCocktail;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CubaLibreMixServiceTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
  private CubaLibreMixService cubaLibreMixService;
  private CubaLibre cubaLibre;

  @Before
  public void setUp() {
    cubaLibreMixService = new CubaLibreMixService();
    cubaLibre = new CubaLibre();
  }

  @Test
  public void testMixCubaLibre() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {
    cubaLibre = cubaLibreMixService.mixCubaLibre(555, 555, 555, 555, 555);
    Assert.assertTrue(cubaLibre.isReadyToDrink());
  }

  @Test
  public void testMixCubaLibreWithNotEnoughGlass() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Glass");

    cubaLibreMixService.mixCubaLibre(CubaLibre.GLASS_AMOUNT_FOR_RECIPE - 1, 500, 500, 500, 500);
  }

  @Test
  public void testMixCubaLibreWithNotEnoughCoke() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Coke");

    cubaLibreMixService.mixCubaLibre(500, CubaLibre.COKE_AMOUNT_FOR_RECIPE - 1, 500, 500, 500);
  }

  @Test
  public void testMixCubaLibreWithNotEnoughIce() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Ice");

    cubaLibreMixService.mixCubaLibre(500, 500, CubaLibre.ICE_AMOUNT_FOR_RECIPE - 1, 500, 500);
  }

  @Test
  public void testMixCubaLibreWithNotEnoughRum() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Rum");

    cubaLibreMixService.mixCubaLibre(500, 500, 500, CubaLibre.RUM_AMOUNT_FOR_RECIPE - 1, 500);
  }

  @Test
  public void testMixCubaLibreWithNotEnoughLime() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Lime");

    cubaLibreMixService.mixCubaLibre(500, 500, 500, 500, CubaLibre.LIME_AMOUNT_FOR_RECIPE - 1);
  }

}