package org.packt.springboot22.vid06.model.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProfileForm {
	private Long id;
	private String name;
	private String mobile;
	private String address;
	private String email;
	
	private String username;
	private String password;
	private boolean approved;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate bday;


}
