package com.lazygrocer.smartshoppinglist.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;
@RestController
@RequestMapping("/api/meals")
public class MealApiController {
	@Resource
	private MealRepository mealRepo;

	@PostMapping("/add-meal")
	public Meal addMeal(@RequestBody Meal meal) {

		return mealRepo.save(meal);

	}

}
