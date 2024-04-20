package com.recipesharing.app.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@jakarta.persistence.Entity
@Table(name= "recipe")
public class RecipeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recipeId")
	private Long recipeId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="ingredients")
	private String ingredients;
	
	@Column(name="preperationSteps")
	private String preperationSteps;
	
	@Column(name="category")
	private String category;
	
	@Column(name="cuisine")
	private String cuisine;
	
	@Column(name="difficulty")
	private String difficulty;
	
	public RecipeEntity() {
		super();
	}
	
	public RecipeEntity(long recipeId, String title, String description, String ingredients, String preperationSteps,
			String category, String cuisine, String difficulty) {
		super();
		this.recipeId = recipeId;
		this.title = title;
		this.description = description;
		this.ingredients = ingredients;
		this.preperationSteps = preperationSteps;
		this.category = category;
		this.cuisine = cuisine;
		this.difficulty = difficulty;
	}

	public long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getPreperationSteps() {
		return preperationSteps;
	}

	public void setPreperationSteps(String preperationSteps) {
		this.preperationSteps = preperationSteps;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	
	
	
}
