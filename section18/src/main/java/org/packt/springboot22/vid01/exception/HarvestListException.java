package org.packt.springboot22.vid01.exception;

//@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "incomplete email form data")
public class HarvestListException extends Exception{
	
	private String message;
	
	public HarvestListException() { }
	
	public HarvestListException(String message) {
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
