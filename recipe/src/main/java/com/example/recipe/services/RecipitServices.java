package com.example.recipe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.recipe.exceptionhandler.NotRecipeFoundException;
import com.example.recipe.exceptionhandler.RecipeConfitException;
import com.example.recipe.model.Recipe;
import com.example.recipe.reposotries.RecipeRepo;
import com.example.recipe.util.Meal;

@Service
public class RecipitServices {
	
final private RecipeRepo recipeRepo;
@Autowired
public RecipitServices(RecipeRepo recipeRepo) {
	  this.recipeRepo=recipeRepo;
}
/**
 * 
 * @return all exiting Recipe
 */
public List<Recipe> getAllRecipes()
{
	return recipeRepo.findAll();
	 
}

/**
 *  method to add new Recipe
 */

public void addNewRecipe(Recipe recipe)
{
	Optional<Recipe> r= recipeRepo.findByTitle(recipe.getTitle());
	if(r.isPresent())
	{
		throw new RecipeConfitException(String.format("the Recipe with the title [%s] exist try another name", recipe.getTitle()));
	}else {
	 recipeRepo.save(recipe);
	 }
	
	
}

/**
 *  method to get Recipe byId
 */

public Recipe getRecipeID(int id)
{
	return recipeRepo.findById(id)
			.orElseThrow(()->new NotRecipeFoundException(String.format("No Recipe with the id [%s] was found in our database", id)));
			
}


/**
 *  method to delete a Recipe
 */

public void deleteRecipe(int id)
{
	boolean exist = recipeRepo.existsById(id);
	if(!exist)
	{
		throw new NotRecipeFoundException(String.format("No Recipe with the id [%s] was found in our database", id));
	}else
	{
	recipeRepo.deleteById(id);
	}
}

/**
 *  get list of Recipe by Meal 
 */
public List<Recipe> getRecipesByMeal(Meal meal)
{
	return recipeRepo.findByMeal(meal);
}

/**
 * method to get or search by title
 */
public List<Recipe> searchBytitle(String title)
{
	return recipeRepo.findByTitleContaining(title);
	 
}
/**
 * update Recipe
 */
@Transactional
public void  updateRecipe( Recipe recipe, int id) {	
	Recipe recipeToUpdate= recipeRepo.findById(id)		
		          .orElseThrow(()->new NotRecipeFoundException(String.format("No Recipe with the id [%s] was found to update in our database", id)));

	    recipeToUpdate.setDificulty(recipe.getDificulty());
	    recipeToUpdate.setMeal(recipe.getMeal());
	    recipeToUpdate.setIngredients(recipe.getIngredients());
	    recipeToUpdate.setPeople_nmbr(recipe.getPeople_nmbr());
	    recipeToUpdate.setSteps(recipe.getSteps());
		recipeToUpdate.setTitle(recipe.getTitle());
		recipeRepo.save(recipeToUpdate);
	}
	

}
