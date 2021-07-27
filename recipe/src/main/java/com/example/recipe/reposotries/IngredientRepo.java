package com.example.recipe.reposotries;

import org.springframework.data.jpa.repository.JpaRepository;
 

import com.example.recipe.model.Ingredient;

public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {

}
