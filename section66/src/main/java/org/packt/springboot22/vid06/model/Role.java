package org.packt.springboot22.vid06.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "role")
@Data
public class Role {
	
	@Id
	private Long id;
	private String name;
	private String description;
	
	

}
