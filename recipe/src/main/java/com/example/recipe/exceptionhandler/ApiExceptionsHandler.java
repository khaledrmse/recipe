package com.example.recipe.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDetail> handleApiExceptions(ApiException e, WebRequest request){
        ErrorDetail detail = new ErrorDetail(e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detail, e.getStatusCode());
    }

}
