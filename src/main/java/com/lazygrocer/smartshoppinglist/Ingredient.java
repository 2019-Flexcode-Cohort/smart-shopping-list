package com.lazygrocer.smartshoppinglist;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Ingredient {

    private String name;
    @Id
	@GeneratedValue
	private long id;

    @OneToMany(mappedBy="ingredient")
	private List<MealIngredient> mealIngredients;
    
    public Ingredient(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

	public long getId() {
		return id;
	}
}
