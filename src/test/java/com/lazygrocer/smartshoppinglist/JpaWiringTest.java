package com.lazygrocer.smartshoppinglist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {

	@Resource
	 private IngredientRepository ingredientRepo;
	@Resource
	private MealRepository mealRepo;
	@Resource
	TestEntityManager entityManager;
	
	
	@Test
	public void mealsShouldHaveAListOfIngs() throws Exception {
		Ingredient testIngredient = new Ingredient("name", 1);
		testIngredient= ingredientRepo.save(testIngredient);
		Ingredient testIngredient2 = new Ingredient("name", 2);
		testIngredient2= ingredientRepo.save(testIngredient2);
		Meal testMeal = new Meal("name", 1, testIngredient, testIngredient2);
		testMeal = mealRepo.save(testMeal);
		
		entityManager.flush();
		entityManager.clear();
		
		Meal retrievedMeal=mealRepo.findById(testMeal.getId()).get();
		assertThat(retrievedMeal.getIngredients(),containsInAnyOrder(testIngredient2, testIngredient));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
