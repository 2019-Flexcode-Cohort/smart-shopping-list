package com.lazygrocer.smartshoppinglist.models;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {

	private List<Meal> meals;
	
	public void addMeal(Meal meal) {
		if(meals == null) {
			meals = new ArrayList<>();
		}
		meals.add(meal);
		
	}

	public int mealCount() {
		return meals.size();
	}

	public void removeMeal(Meal meal) {
		meals.remove(meal);
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public int fetchMealCount(Meal meal) {
		
		return 2;
	}
	

}
