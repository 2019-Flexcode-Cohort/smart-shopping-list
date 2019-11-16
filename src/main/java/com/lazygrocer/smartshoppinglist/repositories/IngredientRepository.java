package com.lazygrocer.smartshoppinglist.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lazygrocer.smartshoppinglist.models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
