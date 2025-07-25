package com.rest.webservices.restful_web_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {

	public UserNotFound(String string) {

		super(string);
	}

}
