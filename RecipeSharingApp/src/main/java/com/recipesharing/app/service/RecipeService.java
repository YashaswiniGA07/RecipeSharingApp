package com.recipesharing.app.service;


import java.util.List;
import java.util.Optional;

import com.recipesharing.app.entity.RecipeEntity;

public interface RecipeService {
	List<RecipeEntity> getAllRecipes();
	Optional<RecipeEntity> getRecipeById(Long recipeId);
	RecipeEntity createRecipe(RecipeEntity recipe);
	RecipeEntity updateRecipe(RecipeEntity recipe);
	String deleteRecipe(Long recipeId);
}
