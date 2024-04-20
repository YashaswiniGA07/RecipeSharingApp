package com.recipesharing.app.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipesharing.app.entity.RecipeEntity;
import com.recipesharing.app.repository.RecipeRepository;
import com.recipesharing.app.service.RecipeService;



@Service
public class RecipeServiceImpl implements RecipeService {
	private final RecipeRepository reciperepo;


	@Autowired
	public RecipeServiceImpl(RecipeRepository reciperepo)
	{
		this.reciperepo=reciperepo;
	}


	@Override
	public List<RecipeEntity> getAllRecipes() {
		// TODO Auto-generated method stub
		return reciperepo.findAll();
	}

	@Override
	public Optional<RecipeEntity> getRecipeById(Long recipeId) {
		// TODO Auto-generated method stub
		return reciperepo.findById(recipeId);
	}

	@Override
	public RecipeEntity createRecipe(RecipeEntity recipe) {
		// TODO Auto-generated method stub
		return reciperepo.save(recipe);
	}

	@Override
	public RecipeEntity updateRecipe(RecipeEntity recipe) {
		// TODO Auto-generated method stub
		Long recipeId = recipe.getRecipeId(); 
	    Optional<RecipeEntity> existingRecipeOptional = reciperepo.findById(recipeId);
	    
	    if (existingRecipeOptional.isPresent()) {
	        RecipeEntity existingRecipe = existingRecipeOptional.get();
	        existingRecipe.setTitle(recipe.getTitle());
	        existingRecipe.setDescription(recipe.getDescription());
	        existingRecipe.setIngredients(recipe.getIngredients());
	        existingRecipe.setPreperationSteps(recipe.getPreperationSteps());
	        existingRecipe.setCategory(recipe.getCategory());
	        existingRecipe.setCuisine(recipe.getCuisine());
	        existingRecipe.setDifficulty(recipe.getDifficulty());
	        
	        
	        return reciperepo.save(existingRecipe);
	    } else {
	        // Recipe with the given ID not found
	        throw new RuntimeException("Recipe not found with ID: " + recipeId);
	    }
	}

	@Override
	public String deleteRecipe(Long recipeId) {
		// TODO Auto-generated method stub
		reciperepo.deleteById(recipeId);
		return "Recipe Deleted Succesfully";
		
	}
	
	
	
	
}

