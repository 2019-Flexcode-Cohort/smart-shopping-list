package com.lazygrocer.smartshoppinglist;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
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
	private MealIngredient mealIngredient;
	@Mock
	private MealIngredient anotherMealIngredient;

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
		MealIngredient mealIngredientOne = new MealIngredient("ingredient one", 2);
		MealIngredient mealIngredientTwo = new MealIngredient("ingredient two", 6);
		MealIngredient ingreidentThree = new MealIngredient("ingredient three", 14);
		
		String mealName = "meal name";
		underTest.addMeal(mealName, 4);
		
		Meal newMeal = new Meal(mealName, 1, mealIngredientOne, mealIngredientTwo, ingreidentThree);
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
		Meal testMeal = mock(Meal.class);
		when(mealRepo.findById(1L)).thenReturn(Optional.of(testMeal));
		underTest.changeMealName(1L,"newName");
		verify(testMeal).changeName("newName");
	}
	public void shouldDeleteIngredientFromMeal() {
		MealIngredient mealIngredientOne = mock(MealIngredient.class);
		when(ingredientRepo.findById(1L)).thenReturn(Optional.of(mealIngredientOne));
		when(mealRepo.findById(2L)).thenReturn(Optional.of(meal));
		
		
		underTest.deleteIngredientFromMeal(2L, 1L);
		
		verify(meal).remove(mealIngredientOne);
		
		
		
	}
	
	
}
