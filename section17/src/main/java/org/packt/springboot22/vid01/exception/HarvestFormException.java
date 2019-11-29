package org.packt.springboot22.vid01.exception;

public class HarvestFormException extends Exception{
	
	private String message;
	
	public HarvestFormException() { }
	
	public HarvestFormException(String message) {
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
