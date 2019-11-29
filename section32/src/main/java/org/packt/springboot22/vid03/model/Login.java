package org.packt.springboot22.vid03.model;

import lombok.Data;

@Data
public class Login {
	
	private Long id;	
	private String username;
	private String password;
	private String passphrase;
}
