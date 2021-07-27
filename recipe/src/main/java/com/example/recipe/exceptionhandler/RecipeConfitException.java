package com.example.recipe.exceptionhandler;

import org.springframework.http.HttpStatus;
/**
 * 
 * exception that handle the confilt when adding recipe to existing
 *
 */
public class RecipeConfitException extends ApiException {

	
	public RecipeConfitException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getStatusCode() {
	 
		return HttpStatus.CONFLICT;
	}

}
