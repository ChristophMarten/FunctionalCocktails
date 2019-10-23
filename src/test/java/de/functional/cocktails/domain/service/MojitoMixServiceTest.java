package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Mojito;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MojitoMixServiceTest {

  @Test
  public void mixMojito() {
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
  MojitoMixService mojitoMixService;
  Mojito mojito;

  @Before
  public void setUp() {
    mojitoMixService = new MojitoMixService();
    mojito = new Mojito();
  }

  @Test
  public void testMixMojito() throws NotEnoughItemsFromIngredient {
    Mojito mojito = mojitoMixService.mixMojito(555, 555, 555, 555, 555, 555, 555);
    Assert.assertTrue(mojito.isReadyToDrink());
  }

  @Test
  public void testMixMojitoWithNotEnoughGlass() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Glass");

    mojitoMixService.mixMojito(mojito.getGlassAmountForRecipe() - 1, 500, 500, 500, 500, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughBrownSugar() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Brown Sugar");

    mojitoMixService.mixMojito(500, 500, 500, 500, 500, mojito.getBrownSugarAmountForRecipe() - 1, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughSoda() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Soda");

    mojitoMixService.mixMojito(500, 500, mojito.getSodaAmountForRecipe() - 1, 500, 500, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughIce() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Ice");

    mojitoMixService.mixMojito(500, 500, 500, 500, mojito.getIceAmountForRecipe() - 1, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughRum() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Rum");

    mojitoMixService.mixMojito(500, mojito.getRumAmountForRecipe() - 1, 500, 500, 500, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughLime() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Lime");

    mojitoMixService.mixMojito(500, 500, 500, mojito.getLimeAmountForRecipe() - 1, 500, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughMint() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Mint");

    mojitoMixService.mixMojito(500, 500, 500, 500, 500, 555, mojito.getMintAmountForRecipe() - 2);
  }

}