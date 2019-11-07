package com.lazygrocer.smartshoppinglist;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meal, Long> {

	Meal findByName(String mealName);

	Collection<Meal> findAllByOrderByNameAsc();

}
