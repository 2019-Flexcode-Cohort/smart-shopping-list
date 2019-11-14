package com.lazygrocer.smartshoppinglist;

import org.springframework.data.repository.CrudRepository;

public interface MealIngredientRepository extends CrudRepository<MealIngredient, Long> {

	MealIngredient findByIngredientName(MealIngredient[] mealIngredients);

}
