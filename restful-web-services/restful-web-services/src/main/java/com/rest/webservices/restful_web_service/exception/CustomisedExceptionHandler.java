package com.rest.webservices.restful_web_service.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.restful_web_services.bean.ErrorDetails;

//it used to make applicable to all controller
@ControllerAdvice
public class CustomisedExceptionHandler extends ResponseEntityExceptionHandler {

	// Handles all unhandled exceptions globally
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDate.now(), ex.getFieldError().getDefaultMessage(),
				request.getDescription(false));
		return new ResponseEntity(details, HttpStatus.BAD_REQUEST);
	}
}
