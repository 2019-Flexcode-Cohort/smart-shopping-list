package com.lazygrocer.smartshoppinglist.models;

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
    
    protected Ingredient() {}
    public Ingredient(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
