package org.packt.springboot22.vid02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.INTERNAL_SERVER_ERROR)
public class MissingResourceException extends Exception{

	private String message;
	
	public MissingResourceException() { }
	
	public MissingResourceException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(message);
	}
}
