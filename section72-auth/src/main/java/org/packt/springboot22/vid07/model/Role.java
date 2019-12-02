package org.packt.springboot22.vid07.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {
	
	@Id
	private Long id;
	private String name;
	private String description;
	
	@OneToMany(targetEntity = PermissionSets.class,
			mappedBy = "id",  orphanRemoval = false, 
			fetch = FetchType.LAZY)
	private Set<Role> role;

}
