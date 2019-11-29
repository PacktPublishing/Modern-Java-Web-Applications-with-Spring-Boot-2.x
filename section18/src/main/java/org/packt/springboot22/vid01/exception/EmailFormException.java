package org.packt.springboot22.vid01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "incomplete email form data")
public class EmailFormException extends Exception{
	
	private String message;
	
	public EmailFormException() { }
	
	public EmailFormException(String message) {
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
