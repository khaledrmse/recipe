package com.example.recipe;
 
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Recipe;
import com.example.recipe.reposotries.RecipeRepo;
import com.example.recipe.util.Dificulty;
import com.example.recipe.util.Meal;

@SpringBootApplication
public class RecipeApplication implements  CommandLineRunner{
	@Autowired
	private RecipeRepo reciperepo;
	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		///
		Ingredient ing1 = new Ingredient();
		ing1.setIngredient_name("sugar");
		ing1.setAmount((long)2);
		Ingredient ing2 = new Ingredient();
		ing2.setIngredient_name("milk");
		ing2.setAmount((long)10);
		Ingredient ing3 = new Ingredient();
		ing3.setIngredient_name("butter");
		ing3.setAmount((long)5);
		//////
		Ingredient ing11 = new Ingredient();
		ing11.setIngredient_name("salt");
		ing11.setAmount((long)2);
		Ingredient ing22 = new Ingredient();
		ing22.setIngredient_name("beard");
		ing22.setAmount((long)10);
		Ingredient ing33 = new Ingredient();
		ing33.setIngredient_name("meat");
		ing33.setAmount((long)5);
		//////
		Ingredient ing111 = new Ingredient();
		ing111.setIngredient_name("salt");
		ing111.setAmount((long)2);
		Ingredient ing222 = new Ingredient();
		ing222.setIngredient_name("vigen");
		ing222.setAmount((long)10);
		Ingredient ing333 = new Ingredient();
		ing333.setIngredient_name("beard");
		ing333.setAmount((long)5);
	
		List<Ingredient> ingredientlist = Arrays.asList(ing1,ing2,ing3);
		List<Ingredient> ingredientlist1 = Arrays.asList(ing11,ing22,ing33);
		List<Ingredient> ingredientlist2 = Arrays.asList(ing111,ing222,ing333);
		Recipe recipe= new Recipe();
		recipe.setMeal(Meal.breakfast);
		recipe.setDificulty(Dificulty.beginner);
		recipe.setTitle("Mornning breakfast");
		recipe.setPeople_nmbr(12);
		recipe.setSteps("mix to gether");
		recipe.setImgurl("hhhhhhh");
		recipe.setIngredients(ingredientlist);
		reciperepo.save(recipe);
		//
		Recipe recipe1= new Recipe();
		recipe1.setMeal(Meal.lunch);
		recipe1.setDificulty(Dificulty.intermediate);
		recipe1.setTitle("launch");
		recipe1.setPeople_nmbr(1);
		recipe1.setSteps("mix to gether");
		recipe1.setIngredients(ingredientlist1);
		recipe1.setImgurl("hhhhhhh");
		reciperepo.save(recipe1);
		//
		Recipe recipe3= new Recipe();
		recipe3.setMeal(Meal.lunch);
		recipe3.setDificulty(Dificulty.advanced);
		recipe3.setTitle("launch");
		recipe3.setPeople_nmbr(1);
		recipe3.setSteps("mix to gether");
		recipe3.setIngredients(ingredientlist2);
		recipe3.setImgurl("hhhhhhh");
		reciperepo.save(recipe3);
	}
	
}
