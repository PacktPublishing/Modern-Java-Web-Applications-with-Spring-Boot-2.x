package org.packt.springboot22.vid02.exception;

import java.util.ArrayList;
import java.util.List;

import org.packt.springboot22.vid02.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FormSignupExceptionHandler {
	
	@ExceptionHandler(value = MissingResourceException.class)
	@ResponseStatus( value = HttpStatus.INTERNAL_SERVER_ERROR)
	public List<Profile> resolveMissingResource(){
		return new ArrayList<>();
	}

}
