package de.functional.cocktails.domain.entity;

import de.functional.cocktails.domain.exception.NotEnoughIngredientsForCocktail;
import de.functional.cocktails.domain.exception.NotEnoughItemsFromIngredient;
import de.functional.cocktails.domain.valueObject.PreparingType;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.function.IntPredicate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PrepareIngredientsFunctionsTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testPrepareIngredient() throws NotEnoughItemsFromIngredient {

    Ingredient lime = new Ingredient("Lime");
    lime.prepare(PreparingType.CUT, 4, 3, IngredientsFunctions.prepareIngredient);

    Assert.assertTrue(lime.isPrepared());
  }

  @Test
  public void testPrepareIngredientWithNotEnoughItems() throws NotEnoughItemsFromIngredient {

    expectedEx.expect(NotEnoughItemsFromIngredient.class);
    expectedEx.expectMessage("Not enough Lime");

    Ingredient lime = new Ingredient("Lime");
    lime.prepare(PreparingType.CUT, 2, 3, IngredientsFunctions.prepareIngredient);

    Assert.assertNotNull(lime);
  }

  @Test
  public void testEnoughIngredients() throws NotEnoughIngredientsForCocktail {
    List<Ingredient> ingredients = List.of(new Ingredient("Lime"), new Ingredient("Lime"), new Ingredient("Lime"));
    IntPredicate pred = iS -> iS == 3;
    boolean enoughIngredients = IngredientsFunctions.enoughIngredients(pred, ingredients);
    Assert.assertTrue(enoughIngredients);
  }

  @Test
  public void testEnoughIngredientsWithNotEnoughIngredients() throws NotEnoughIngredientsForCocktail {

    expectedEx.expect(NotEnoughIngredientsForCocktail.class);
    expectedEx.expectMessage("Not enough ingredients available");

    List<Ingredient> ingredients = List.of(new Ingredient("Lime"));
    IntPredicate pred = iS -> iS == 6;
    IngredientsFunctions.enoughIngredients(pred, ingredients);

    Assert.assertNotNull(ingredients);
  }

  @Test
  public void testLogIsIngredientPrepared() {
    List<Ingredient> ingredients = List.of(new Ingredient("Lime"), new Ingredient("Ice"));
    IngredientsFunctions.logIsIngredientPrepared("Ice", ingredients);

    Assert.assertTrue(outContent.toString().contains("Ice isPrepared = false"));
  }

}