package org.packt.springboot22.vid03.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "login")
public class Login {
	
	@Id
	private Long id;	
	private String username;
	private String password;
	private String passphrase;
}
