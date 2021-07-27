package com.example.recipe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.example.recipe.util.Dificulty;
import com.example.recipe.util.Meal;

import lombok.Data;
/**
 * @author Slimani khaled
 * @ Recipe Model
 */
@Entity
@Data
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message = "Title is required")
	private String title;
	@Enumerated(EnumType.STRING)
	private Meal meal;
	private int people_nmbr;
	@Enumerated(EnumType.STRING)
	private Dificulty dificulty;
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Ingredient> ingredients;
	private String Steps;
	private String imgurl;
	
	
	
	
}
