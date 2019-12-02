package org.packt.springboot22.vid05.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Table(name = "permission_sets")
@Data
public class PermissionSets {

	@Id
	private Long id;
	private Long loginId;
	private Long permId;
	private Long roleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loginId", insertable = false,  updatable = false)
	@Fetch(FetchMode.JOIN)
	private Login login;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permId", insertable = false,  updatable = false)
	@Fetch(FetchMode.JOIN)
	private Permission permission;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", insertable = false,  updatable = false)
	@Fetch(FetchMode.JOIN)
	private Role role;

}
