package com.example.recipe.reposotries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
 

import com.example.recipe.model.Recipe;
import com.example.recipe.util.Meal;

public interface RecipeRepo extends JpaRepository<Recipe, Integer> {

	
	
	Optional<Recipe>findByTitle(String title);
	//findby id
	Optional<Recipe> findById(Integer id) ;
	//find by meal category 
	List<Recipe> findByMeal(Meal meal);
	//to make search by title
	List<Recipe>findByTitleContaining(String title);
	
}
