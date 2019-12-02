package org.packt.springboot22.vid06.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "permission_sets")
@Data
public class PermissionSets {

	@Id
	private Long id;
	private Long loginId;
	private Long permId;
	private Long roleId;
	
	
}
