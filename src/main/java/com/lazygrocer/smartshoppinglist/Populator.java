package com.lazygrocer.smartshoppinglist;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	private MealRepository mealRepo;

	@Resource
	MealIngredientRepository mealIngredientRepo;
	@Resource
	IngredientRepository ingredientRepo;

	@Override
	public void run(String... args) throws Exception {

		Ingredient iButter = new Ingredient("butter");
		iButter = ingredientRepo.save(iButter);
		MealIngredient butter = new MealIngredient(iButter, 1);
		butter = mealIngredientRepo.save(butter);

		Ingredient iMilk = ingredientRepo.save(new Ingredient("milk"));
		MealIngredient milk = new MealIngredient(iMilk, 1);
		milk = mealIngredientRepo.save(milk);

		Ingredient iMacaroni = ingredientRepo.save(new Ingredient("macaroni"));
		MealIngredient macaroni = new MealIngredient(iMacaroni, 1);
		macaroni = mealIngredientRepo.save(macaroni);

		Ingredient iVelveeta = ingredientRepo.save(new Ingredient("velveeta"));
		MealIngredient velveeta = new MealIngredient(iVelveeta, 1);
		velveeta = mealIngredientRepo.save(velveeta);
		
		Ingredient iBread = ingredientRepo.save(new Ingredient("bread"));
		MealIngredient bread = new MealIngredient(iBread, 2);
		bread = mealIngredientRepo.save(bread);

		Ingredient iEgg = ingredientRepo.save(new Ingredient("egg"));
		MealIngredient egg = new MealIngredient(iEgg, 1);
		egg = mealIngredientRepo.save(egg);

		Meal meal1 = new Meal("Mac & Cheese", 2, butter, milk, macaroni, velveeta);
		meal1 = mealRepo.save(meal1);
		Meal meal2 = new Meal("Grilled Cheese", 1, butter, bread, velveeta);
		meal2 = mealRepo.save(meal2);
		Meal meal3 = new Meal("Scrambled Eggs", 1, butter, egg, milk);
		meal3 = mealRepo.save(meal3);

	}

}
