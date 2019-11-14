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
		MealIngredient testMealIngredient = new MealIngredient("name", 1);
		testMealIngredient = ingredientRepo.save(testMealIngredient);
		MealIngredient testMealIngredient2 = new MealIngredient("name", 2);
		testMealIngredient2 = ingredientRepo.save(testMealIngredient2);
		Meal testMeal = new Meal("name", 1, testMealIngredient, testMealIngredient2);
		testMeal = mealRepo.save(testMeal);
		
		entityManager.flush();
		entityManager.clear();
		
		Meal retrievedMeal=mealRepo.findById(testMeal.getId()).get();
		assertThat(retrievedMeal.getMealIngredients(),containsInAnyOrder(testMealIngredient2, testMealIngredient));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
