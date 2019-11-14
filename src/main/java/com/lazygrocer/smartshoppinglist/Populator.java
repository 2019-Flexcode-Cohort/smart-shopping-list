package com.lazygrocer.smartshoppinglist;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	private MealRepository mealRepo;

	@Resource
	IngredientRepository IngredientRepo;

	@Override
	public void run(String... args) throws Exception {

		MealIngredient butter = new MealIngredient("butter", 1);
		butter = IngredientRepo.save(butter);
		MealIngredient milk = new MealIngredient("milk", 1);
		milk = IngredientRepo.save(milk);
		MealIngredient macaroni = new MealIngredient("macaroni", 1);
		macaroni = IngredientRepo.save(macaroni);
		MealIngredient velveta = new MealIngredient("velveta", 1);
		velveta = IngredientRepo.save(velveta);
		MealIngredient bread = new MealIngredient("bread", 2);
		bread = IngredientRepo.save(bread);
		MealIngredient egg = new MealIngredient("egg", 1);
		egg = IngredientRepo.save(egg);

		Meal meal1 = new Meal("Mac & Cheese", 2, butter, milk, macaroni, velveta);
		meal1 = mealRepo.save(meal1);
		Meal meal2 = new Meal("Grilled Cheese", 1, butter, bread, velveta);
		meal2 = mealRepo.save(meal2);
		Meal meal3 = new Meal("Scrambled Eggs", 1, butter, egg, milk);
		meal3 = mealRepo.save(meal3);

	}

}
