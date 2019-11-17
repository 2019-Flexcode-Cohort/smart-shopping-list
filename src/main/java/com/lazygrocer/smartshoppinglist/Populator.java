package com.lazygrocer.smartshoppinglist;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lazygrocer.smartshoppinglist.models.Ingredient;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.models.MealIngredient;
import com.lazygrocer.smartshoppinglist.repositories.IngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealIngredientRepository;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

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

		Ingredient iMilk = ingredientRepo.save(new Ingredient("milk"));

		Ingredient iMacaroni = ingredientRepo.save(new Ingredient("macaroni"));

		Ingredient iVelveeta = ingredientRepo.save(new Ingredient("velveeta"));

		Ingredient iBread = ingredientRepo.save(new Ingredient("bread"));

		Ingredient iEgg = ingredientRepo.save(new Ingredient("egg"));

		MealIngredient butter1 = mealIngredientRepo.save(new MealIngredient(iButter, 1));
		MealIngredient milk1 = mealIngredientRepo.save(new MealIngredient(iMilk, 1));
		MealIngredient macaroni1 = mealIngredientRepo.save(new MealIngredient(iMacaroni, 1));
		MealIngredient velveeta1 = mealIngredientRepo.save(new MealIngredient(iVelveeta, 1));
		Meal meal1 = new Meal("Mac & Cheese", 2, butter1, milk1, macaroni1, velveeta1);
		meal1 = mealRepo.save(meal1);
		butter1 = mealIngredientRepo.save(butter1);
		milk1 = mealIngredientRepo.save(milk1);
		macaroni1 = mealIngredientRepo.save(macaroni1);
		velveeta1 = mealIngredientRepo.save(velveeta1);
		
		MealIngredient butter2 = mealIngredientRepo.save(new MealIngredient(iButter, 1));
		MealIngredient velveeta2 = mealIngredientRepo.save(new MealIngredient(iVelveeta, 1));
		MealIngredient bread2 = mealIngredientRepo.save(new MealIngredient(iBread, 2));
		Meal meal2 = new Meal("Grilled Cheese", 1, butter2, bread2, velveeta2);
		meal2 = mealRepo.save(meal2);
		butter2 = mealIngredientRepo.save(butter2);
		velveeta2 = mealIngredientRepo.save(velveeta2);
		bread2 = mealIngredientRepo.save(bread2);
		
		MealIngredient butter3 = mealIngredientRepo.save(new MealIngredient(iButter, 1));
		MealIngredient milk3 = mealIngredientRepo.save(new MealIngredient(iMilk, 1));
		MealIngredient egg3 = mealIngredientRepo.save(new MealIngredient(iEgg, 1));
		Meal meal3 = new Meal("Scrambled Eggs", 1, butter3, egg3, milk3);
		meal3 = mealRepo.save(meal3);

		butter3 = mealIngredientRepo.save(butter3);
		milk3 = mealIngredientRepo.save(milk3);
		egg3 = mealIngredientRepo.save(egg3);

	}

}
