package org.packt.springboot22.vid06.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table(value = "signup")
@Data
public class Profile {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(value="name")
	private String name;
	
	@Column(value="mobile")
	private String mobile;
	
	@Column(value="address")
	private String address;
	
	@Column(value="email")
	private String email;
	
	@Column(value="username")
	private String username;
	
	@Column(value="password")
	private String password;
	
	@Column(value="approved")
	private boolean approved;
	
	@Column(value="birthday")
	private LocalDate bday;
	
	
	
	
}
