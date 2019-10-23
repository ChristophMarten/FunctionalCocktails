package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Caipirinha;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CaipirinhaMixServiceTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
  CaipirinhaMixService caipirinhaMixService;
  Caipirinha caipirinha;

  @Before
  public void setUp() {
    caipirinhaMixService = new CaipirinhaMixService();
    caipirinha = new Caipirinha();
  }

  @Test
  public void testMixCaipirinha() throws NotEnoughItemsFromIngredient {
    Caipirinha caipirinha = caipirinhaMixService.mixCaipirinha(555, 555, 555, 555, 555);
    Assert.assertTrue(caipirinha.isReadyToDrink());
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughGlass() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Glass");

    caipirinhaMixService.mixCaipirinha(caipirinha.getGlassAmountForRecipe() - 1, 500, 500, 500, 500);
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughCachaca() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Cachaca");

    caipirinhaMixService.mixCaipirinha(500, caipirinha.getCachacaAmountForRecipe() - 1, 500, 500, 500);
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughIce() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Ice");

    caipirinhaMixService.mixCaipirinha(500, 500, caipirinha.getIceAmountForRecipe() - 1, 500, 500);
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughRum() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough BrownSugar");

    caipirinhaMixService.mixCaipirinha(500, 500, 500, caipirinha.getBrownSugarAmountForRecipe() - 1, 500);
  }

  @Test
  public void testMixCaipirinhaWithNotEnoughLime() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Lime");

    caipirinhaMixService.mixCaipirinha(500, 500, 500, 500, caipirinha.getLimeAmountForRecipe() - 1);
  }

}