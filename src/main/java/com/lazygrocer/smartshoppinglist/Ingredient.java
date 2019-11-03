package com.lazygrocer.smartshoppinglist;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient {

	private String name;
	private int quantity;
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToMany(mappedBy="ingredients")
	private List<Meal> meals;

	public Ingredient(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;

	}
	protected Ingredient () {}

	public String getName() {
		return name;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	

}
