package org.packt.springboot22.vid03.model;

import java.time.LocalDate;

import lombok.Data;


@Data
public class Profile {
	
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
