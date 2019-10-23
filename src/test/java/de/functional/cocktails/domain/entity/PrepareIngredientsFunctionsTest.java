package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PrepareIngredientsFunctionsTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testPrepareIngredient() throws NotEnoughItemsFromIngredient{

    Ingredient tomate = new Ingredient("Tomate");
    tomate.prepare(PreparingType.CUT, 4, 3, PrepareIngredientsFunctions.prepareIngredient);

    Assert.assertTrue(tomate.isPrepared());
  }

  @Test
  public void testPrepareIngredientWithNotEnoughItems() throws NotEnoughItemsFromIngredient{

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Tomate");

    Ingredient tomate = new Ingredient("Tomate");
    tomate.prepare(PreparingType.CUT, 2, 3, PrepareIngredientsFunctions.prepareIngredient);

    Assert.assertNotNull(tomate);
  }

}