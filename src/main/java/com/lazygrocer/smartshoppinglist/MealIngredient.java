package com.lazygrocer.smartshoppinglist;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MealIngredient {

	private Ingredient ingredient;
	private int quantity;
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToMany(mappedBy="ingredients")
	private List<Meal> meals;

	public MealIngredient(Ingredient ingredient, int quantity) {
		this.ingredient = ingredient;
		this.quantity = quantity;

	}
	protected MealIngredient() {}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public int getQuantity() {
		return quantity;
	}

	public long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + quantity;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealIngredient other = (MealIngredient) obj;
		if (id != other.id)
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	

}
