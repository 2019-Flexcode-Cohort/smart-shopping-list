package com.lazygrocer.smartshoppinglist;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class MealControllerTest {

	@InjectMocks
	private MealController underTest;

	@Mock
	private MealRepository mealRepo;
	@Mock
	private Meal meal;
	Long mealId;
	
	@Mock
	private Meal anotherMeal;
	@Mock
	private Model model;
	@Mock
	private IngredientRepository ingredientRepo;
	@Mock
	private Ingredient ingredient;
	@Mock
	private Ingredient anotherIngredient;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddSingleMealToModel() throws MealNotFoundException {
		long newMealId = 1;
		when(mealRepo.findById(newMealId)).thenReturn(Optional.of(meal));
		underTest.findOneMeal(newMealId, model);
		verify(model).addAttribute("meal", meal);
	}

	@Test
	public void shouldAddAllMealsToModel() {
		Collection<Meal> allMeals = Arrays.asList(meal, anotherMeal);
		when(mealRepo.findAll()).thenReturn(allMeals);

		underTest.findAllMeals(model);
		verify(model).addAttribute("meals", allMeals);
	}
	
	@Test
	public void shouldAddAdditionalMealsToModel() {
		Ingredient ingredientOne = new Ingredient("ingredient one", 2);
		Ingredient ingredientTwo = new Ingredient("ingredient two", 6);
		Ingredient ingreidentThree = new Ingredient("ingredient three", 14);
		
		String mealName = "meal name";
		underTest.addMeal(mealName, 4);
		
		Meal newMeal = new Meal(mealName, 1, ingredientOne, ingredientTwo, ingreidentThree);
		when(mealRepo.save(newMeal)).thenReturn(newMeal);
	}
	
	@Test
	public void shouldRemoveMealFromModelByName() {
		String mealName = meal.getName();
		when(mealRepo.findByName(mealName)).thenReturn(meal);
		underTest.deleteMealByName(mealName);
		verify(mealRepo).delete(meal);
	}
	
	@Test 
	public void shouldRemoveMealFromModelById() {
		underTest.deleteMealById(mealId);
		verify(mealRepo).deleteById(mealId);
	}
	
	@Test
	public void shouldChangeMealName() {
		Meal testMeal = new Meal("meal", 1);
		String oldMealName = meal.getName();
		
		when(mealRepo.findByName(oldMealName)).thenReturn(meal);
		underTest.changeMealName("meal","anotherMeal");
		
		Meal updatedMeal =mealRepo.findByName(testMeal.getName());
		assertThat(updatedMeal.getName(), is("anotherMeal"));

	}
}
