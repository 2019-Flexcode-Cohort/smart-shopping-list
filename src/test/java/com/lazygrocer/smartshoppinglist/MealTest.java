package com.lazygrocer.smartshoppinglist;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MealTest {

	@Test
	public void shouldBeAbleToChangeName() {
		Meal testMeal = new Meal("name",1);
		testMeal.changeName("newName");
		assertEquals("newName",testMeal.getName());
	}
	public void shouldBeAbleToRemoveIngredient() {	
		MealIngredient mealIngredientOne = new MealIngredient("ingredient one", 2);
		MealIngredient mealIngredientTwo = new MealIngredient("ingredient two", 6);
		MealIngredient ingreidentThree = new MealIngredient("ingredient three", 14);
		
		Meal meal = new Meal ("meal 1", 2, mealIngredientOne, mealIngredientTwo, ingreidentThree);
		
		meal.remove(mealIngredientOne);
		assertThat(meal.getMealIngredients(), containsInAnyOrder(mealIngredientTwo, ingreidentThree));
		
	}

}
