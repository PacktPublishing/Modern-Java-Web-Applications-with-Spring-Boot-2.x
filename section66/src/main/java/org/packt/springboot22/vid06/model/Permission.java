package org.packt.springboot22.vid06.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "permission")
@Data
public class Permission {
	
	@Id
	private Long id;
	private String name;
	private String description;
	
	
}
