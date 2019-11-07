package com.lazygrocer.smartshoppinglist;

import static org.junit.Assert.*;

import org.junit.Test;

public class MealTest {

	@Test
	public void shouldBeAbleToChangeName() {
		Meal testMeal = new Meal("name",1);
		testMeal.changeName("newName");
		assertEquals("newName",testMeal.getName());
	}

}
