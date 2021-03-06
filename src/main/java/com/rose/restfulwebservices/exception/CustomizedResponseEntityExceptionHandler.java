package com.rose.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rose.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final  ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) 
	{
		ExceptionResponse excResp = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(excResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@ExceptionHandler(UserNotFoundException.class)
//	public final  ResponseEntity<Object> handleNotFoundException(UserNotFoundException ex, WebRequest request) 
//	{
//		ExceptionResponse excResp = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//		return new ResponseEntity(excResp, HttpStatus.NOT_FOUND);
//	}
}
