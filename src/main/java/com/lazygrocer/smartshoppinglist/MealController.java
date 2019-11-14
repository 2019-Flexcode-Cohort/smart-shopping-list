package com.lazygrocer.smartshoppinglist;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MealController {

	@Resource
	private MealRepository mealRepo;
	@Resource
	private MealIngredientRepository mealIngredientRepo;

	@RequestMapping("/meal")
	public String findOneMeal(long id, Model model) throws MealNotFoundException {
		Optional<Meal> meal = mealRepo.findById(id);

		if (meal.isPresent()) {
			model.addAttribute("meal", meal.get());
			return "meal";
		}
		throw new MealNotFoundException();
	}

	@RequestMapping("/meals")
	public String findAllMeals(Model model) {
		model.addAttribute("meals", mealRepo.findAll());
		return ("meals");

	}

//	@RequestMapping("/add-meal")
//	public String addMeal(String mealName, int servings, MealIngredient... mealIngredients) {
//		MealIngredient mealIngredient = mealIngredientRepo.findByName(mealIngredients);
//
//		if (mealIngredient == null) {
//			mealIngredient = new MealIngredient(ingredient, 12);
//			mealIngredientRepo.save(mealIngredient);
//		}
//
//		Meal newMeal = mealRepo.findByName(mealName);
//
//		if (newMeal == null) {
//			newMeal = new Meal(mealName, servings, mealIngredients);
//			mealRepo.save(newMeal);
//		}
//		return "redirect:/meals";
//	}

	@RequestMapping("/delete-meal")
	public String deleteMealByName(String mealName) {
		if (mealRepo.findByName(mealName) != null) {
			Meal deleteMeal = mealRepo.findByName(mealName);
			mealRepo.delete(deleteMeal);
		}
		return "redirect:/meals";
	}

	@RequestMapping("/del-meal")
	public String deleteMealById(Long mealId) {
		mealRepo.deleteById(mealId);
		return "redirect:/meals";
	}
	
	@RequestMapping("/find-meal")
	public String findMeal(String mealName, Model model) {
		model.addAttribute("meals", mealRepo.findByName(mealName));
		return "/meal";
	}
	
	@RequestMapping("/sort-meals")
	public String sortMeals(Model model) {
		model.addAttribute("meals", mealRepo.findAllByOrderByNameAsc());
		return "redirect:/meals";
	}

	@RequestMapping("/change-meal-name/{id}/{newMealName}")
	public String changeMealName(@PathVariable Long id, @PathVariable String newMealName) {
		
		Meal meal = mealRepo.findById(id).get();

			meal.changeName(newMealName);
			mealRepo.save(meal);

		return "redirect:/meal";
	}
	
	@RequestMapping("/meal/{mealId}/remove-ingredient/{ingredientId}")
	public String deleteIngredientFromMeal(@PathVariable Long mealId, @PathVariable Long ingredientId) {
		
		Meal meal = mealRepo.findById(mealId).get();
		MealIngredient mealIngredient = mealIngredientRepo.findById(ingredientId).get();
		meal.remove (mealIngredient);
		
//		get meal
//		get ingredient
//		remove ingredient
		
		return "/meal";
	}

}
