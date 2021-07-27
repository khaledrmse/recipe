package com.example.recipe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Slimani khaled
 *  End point Controller
 */

import com.example.recipe.model.Recipe;
import com.example.recipe.services.RecipitServices;
import com.example.recipe.util.Meal;
@RestController
@RequestMapping(value = "/api/v1/recipe")
public class RecipeController {
	
	final private RecipitServices recipitServices;
	@Autowired
	public RecipeController(RecipitServices recipitServices) {
		 this.recipitServices=recipitServices;
	}
	//get All Recipe
	 @GetMapping("/all")
	    public ResponseEntity<List<Recipe>> getAllRecipes() {
	        List<Recipe> result =  recipitServices.getAllRecipes();
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	//get All Recipe by titleor searching 
		 @GetMapping("/search/{title}")
		    public ResponseEntity<List<Recipe>> getRecipessearch(@PathVariable String title) {
		        List<Recipe> result =  recipitServices.searchBytitle(title);
		        return new ResponseEntity<>(result, HttpStatus.OK);
		    }
	 // get a Recipe by ID
	 @GetMapping("/{id}")
	    public ResponseEntity<Recipe> getRecipeById(@PathVariable  int id) {
		  Recipe result =  recipitServices.getRecipeID(id);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	 // get recipes by meal category
	 @GetMapping("/getbymeal/{meal}")
	  public ResponseEntity<List<Recipe>> getAllRecipesbyMeal(@PathVariable Meal meal) {
	        List<Recipe> result =  recipitServices.getRecipesByMeal(meal);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }

	 //add new Recipe
	 @PostMapping("/saverecipe")
	    public ResponseEntity<Void> createNewRecipe (@Valid @RequestBody Recipe recipe) {
	          recipitServices.addNewRecipe(recipe);
	        return new ResponseEntity<>( HttpStatus.CREATED);
	    }
	 /**
	  * 
	  * update a recipe
	  */
	 @PutMapping("/{id}")
	 public ResponseEntity<Void> updateRecipe(@Valid @RequestBody Recipe recipe, @PathVariable int id) {
	     recipitServices.updateRecipe(recipe, id);
		 return new ResponseEntity<>(HttpStatus.FOUND);
		    }
		 
	 
	 // delete a recipe by id
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
	        recipitServices.deleteRecipe(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 
	 
}
