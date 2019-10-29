package de.functional.cocktails.domain.service;

import de.functional.cocktails.domain.entity.Mojito;
import de.functional.cocktails.domain.exception.NotEnoughIngredientsForCocktail;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MojitoMixServiceTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
  private MojitoMixService mojitoMixService;
  private Mojito mojito;

  @Before
  public void setUp() {
    mojitoMixService = new MojitoMixService();
    mojito = new Mojito();
  }

  @Test
  public void testMixMojito() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {
    mojito = mojitoMixService.mixMojito(555, 555, 555, 555, 555, 555, 555);
    Assert.assertTrue(mojito.isReadyToDrink());
  }

  @Test
  public void testMixMojitoWithNotEnoughGlass() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Glass");

    mojitoMixService.mixMojito(Mojito.GLASS_AMOUNT_FOR_RECIPE - 1, 500, 500, 500, 500, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughBrownSugar() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Brown Sugar");

    mojitoMixService.mixMojito(500, 500, 500, 500, 500, Mojito.BROWN_SUGAR_AMOUNT_FOR_RECIPE - 1, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughSoda() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Soda");

    mojitoMixService.mixMojito(500, 500, Mojito.SODA_AMOUNT_FOR_RECIPE - 1, 500, 500, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughIce() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Ice");

    mojitoMixService.mixMojito(500, 500, 500, 500, Mojito.ICE_AMOUNT_FOR_RECIPE - 1, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughRum() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Rum");

    mojitoMixService.mixMojito(500, Mojito.RUM_AMOUNT_FOR_RECIPE - 1, 500, 500, 500, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughLime() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Lime");

    mojitoMixService.mixMojito(500, 500, 500, Mojito.LIME_AMOUNT_FOR_RECIPE - 1, 500, 555, 555);
  }

  @Test
  public void testMixMojitoWithNotEnoughMint() throws NotEnoughItemsFromIngredient, NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Mint");

    mojitoMixService.mixMojito(500, 500, 500, 500, 500, 555, Mojito.MINT_AMOUNT_FOR_RECIPE - 2);
  }

}