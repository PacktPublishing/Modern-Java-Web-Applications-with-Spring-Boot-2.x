package org.packt.springboot22.vid04.security;

import java.io.Serializable;

public class FarmUpAuthResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public FarmUpAuthResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}