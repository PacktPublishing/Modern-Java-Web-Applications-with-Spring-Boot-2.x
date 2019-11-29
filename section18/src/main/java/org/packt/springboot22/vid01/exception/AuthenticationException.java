package org.packt.springboot22.vid01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "incomplete email form data")
public class AuthenticationException extends Exception{

}
