package com.example.recipe.exceptionhandler;

import org.springframework.http.HttpStatus;

public class NotRecipeFoundException extends ApiException{
	public NotRecipeFoundException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.NOT_FOUND;
	}
}
