package org.packt.springboot22.vid02.model;

import lombok.Data;

@Data
public class Profile {
	
	private String name;
	private String mobile;
	private String address;
	private String email;
	private String username;
	private String password;
	private boolean approved;

}
