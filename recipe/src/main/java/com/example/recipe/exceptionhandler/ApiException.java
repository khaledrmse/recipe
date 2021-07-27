package com.example.recipe.exceptionhandler;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {
	public ApiException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatusCode();
}
