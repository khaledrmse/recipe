package com.example.recipe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 * @author slimani khaled
 * 
 *  Ingrident Model
 */
@Entity
@Data
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ingredient_name;
	private long amount;

}
