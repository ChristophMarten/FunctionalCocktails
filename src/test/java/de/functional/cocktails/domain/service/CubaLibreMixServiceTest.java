package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.CubaLibre;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CubaLibreMixServiceTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
  CubaLibreMixService cubaLibreMixService;
  CubaLibre cubaLibre;

  @Before
  public void setUp() {
    cubaLibreMixService = new CubaLibreMixService();
    cubaLibre = new CubaLibre();
  }

  @Test
  public void testMixCubaLibre() throws NotEnoughItemsFromIngredient {
    CubaLibre cubaLibre = cubaLibreMixService.mixCubaLibre(555, 555, 555, 555, 555);
    Assert.assertTrue(cubaLibre.isReadyToDrink());
  }

  @Test
  public void testMixCubaLibreWithNotEnoughGlass() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Glass");

    cubaLibreMixService.mixCubaLibre(cubaLibre.getGlassAmountForRecipe() - 1, 500, 500, 500, 500);
  }

  @Test
  public void testMixCubaLibreWithNotEnoughCoke() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Coke");

    cubaLibreMixService.mixCubaLibre(500, cubaLibre.getCokeAmountForRecipe() - 1, 500, 500, 500);
  }

  @Test
  public void testMixCubaLibreWithNotEnoughIce() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Ice");

    cubaLibreMixService.mixCubaLibre(500, 500, cubaLibre.getIceAmountForRecipe() - 1, 500, 500);
  }

  @Test
  public void testMixCubaLibreWithNotEnoughRum() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Rum");

    cubaLibreMixService.mixCubaLibre(500, 500, 500, cubaLibre.getRumAmountForRecipe() - 1, 500);
  }

  @Test
  public void testMixCubaLibreWithNotEnoughLime() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Lime");

    cubaLibreMixService.mixCubaLibre(500, 500, 500, 500, cubaLibre.getLimeAmountForRecipe() - 1);
  }

}