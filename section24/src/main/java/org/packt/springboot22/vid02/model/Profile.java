package org.packt.springboot22.vid02.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Carries Personal and Login Data", value = "Profile Information")
@Data
public class Profile {
	
	@ApiModelProperty(notes = "Complete name", dataType = "varchar",  position = 0) 
	
	@NotNull
	@NotBlank
	@Size(min = 6, max = 20)
	private String name;
	
	@ApiModelProperty(notes = "Mobile Number", dataType = "varchar", position = 1) 
	@NotNull
	private String mobile;
	
	@ApiModelProperty(notes = "Complete Address", dataType = "varchar", position = 2) 
	@NotNull
	private String address;
	
	@ApiModelProperty(notes = "Current email address", dataType = "varchar", position = 3) 
	@NotNull
	private String email;
	
	@ApiModelProperty(notes = "Username/Email", dataType = "varchar", position = 4) 
	@NotNull
	private String username;
	 
	@ApiModelProperty(notes = "Strong Password", dataType = "varchar", position = 5)
	@NotNull
	private String password;
	
	@ApiModelProperty(notes = "Admin's Approval", dataType = "true/false", position = 6) 
	@NotNull
	private boolean approved;
	
	

}
