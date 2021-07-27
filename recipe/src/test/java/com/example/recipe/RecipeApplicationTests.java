package com.example.recipe;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Recipe;
import com.example.recipe.reposotries.RecipeRepo;
import com.example.recipe.util.Dificulty;

@SpringBootTest
class RecipeApplicationTests {

	@Autowired
	private RecipeRepo reciperepo;
	@Test
	void addtodatabase() {
		Ingredient ing1 = new Ingredient();
		ing1.setIngredient_name("sale");
		ing1.setAmount((long)10);
		List<Ingredient> ingredientlist = Arrays.asList(ing1);
		Recipe recipe= new Recipe();
		recipe.setDificulty(Dificulty.beginner);
		recipe.setTitle("firstrecipe");
		recipe.setIngredients(ingredientlist);
		
		reciperepo.save(recipe);
		
		
	}

}
