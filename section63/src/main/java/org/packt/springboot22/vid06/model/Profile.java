package org.packt.springboot22.vid06.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "signup")
public class Profile {
	
	@Id
	private Long id;
	private String name;
	private String mobile;
	private String address;
	private String email;
	
	private String username;
	private String password;
	private boolean approved;
	private LocalDate bday;

}
