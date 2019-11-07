package com.lazygrocer.smartshoppinglist;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

import org.junit.Test;

public class MealTest {

	@Test
	public void shouldBeAbleToRemoveIngredient() {	
		Ingredient ingredientOne = new Ingredient("ingredient one", 2);
		Ingredient ingredientTwo = new Ingredient("ingredient two", 6);
		Ingredient ingreidentThree = new Ingredient("ingredient three", 14);
		
		Meal meal = new Meal ("meal 1", 2, ingredientOne, ingredientTwo, ingreidentThree);
		
		meal.remove(ingredientOne);
		assertThat(meal.getIngredients(), containsInAnyOrder(ingredientTwo, ingreidentThree));
		
	}

}
