package com.lazygrocer.smartshoppinglist.controllers;

import javax.annotation.Resource;

import com.lazygrocer.smartshoppinglist.models.Ingredient;
import com.lazygrocer.smartshoppinglist.models.MealIngredient;
import com.lazygrocer.smartshoppinglist.repositories.IngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealIngredientRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/meals")
public class MealApiController {
	@Resource
	private MealRepository mealRepo;
	@Resource
	private IngredientRepository ingredientRepo;
	@Resource
	private MealIngredientRepository mealIngredientRepo;

	@PostMapping("/add-meal")
	public Meal addMeal(@RequestBody Meal meal) {

		for(MealIngredient mealIngredient : meal.getMealIngredients()){
			Optional<Ingredient> ingredientOptional = ingredientRepo.findByName(mealIngredient.getIngredient().getName());
			if(!ingredientOptional.isPresent()){
				mealIngredient.updateIngredient(ingredientRepo.save(new Ingredient(mealIngredient.getIngredient().getName())));
			}else{
				mealIngredient.updateIngredient(ingredientOptional.get());
			}
			mealIngredientRepo.save(mealIngredient);
		}

		return mealRepo.save(meal);

	}

}
