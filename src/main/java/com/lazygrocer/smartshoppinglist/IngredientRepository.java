package com.lazygrocer.smartshoppinglist;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<MealIngredient, Long> {

	MealIngredient findByName(MealIngredient[] mealIngredients);

}
