package com.lazygrocer.smartshoppinglist;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

	Ingredient findByName(Ingredient[] ingredients);

}
