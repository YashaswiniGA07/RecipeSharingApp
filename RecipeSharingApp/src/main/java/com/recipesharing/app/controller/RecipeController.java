package com.recipesharing.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipesharing.app.entity.RecipeEntity;
import com.recipesharing.app.service.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	private final RecipeService recipeSer;
	public RecipeController(RecipeService recipeSer)
	{
		this.recipeSer=recipeSer;
	}
	
	@GetMapping
	public List<RecipeEntity> getAllRecipes()
	{
		return recipeSer.getAllRecipes();
	}
	
	@GetMapping("/{recipeId}")
	public Optional<RecipeEntity> getRecipeById(@PathVariable("recipeId") Long recipeId)
	{
		return recipeSer.getRecipeById(recipeId);
	}
	
	@PostMapping
	public RecipeEntity createRecipe(@RequestBody RecipeEntity recipe)
	{
		return recipeSer.createRecipe(recipe);
	}
	
	@PutMapping("/{recipeId}")
	public RecipeEntity updateRecipee(@PathVariable("recipeId") Long recipeId, @RequestBody RecipeEntity recipe)
	{
		recipe.setRecipeId(recipeId);
		return recipeSer.updateRecipe(recipe);
	}
	
	@DeleteMapping("/{recipeId}")
	public String deleteRecipe(@PathVariable("recipeId") Long recipeId)
	{
		return recipeSer.deleteRecipe(recipeId);
	}
	

}

