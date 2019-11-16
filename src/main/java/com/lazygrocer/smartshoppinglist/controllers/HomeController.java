package com.lazygrocer.smartshoppinglist.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

@Controller
public class HomeController {

	@Resource
	private MealRepository mealRepo;

	
	public String serveHomePage(Model model) {
		model.addAttribute("meals", mealRepo.findAll());
		return "home";
	}

}
