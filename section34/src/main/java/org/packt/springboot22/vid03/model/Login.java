package org.packt.springboot22.vid03.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "login")
@Data
public class Login {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="passphrase")
	private String passphrase;
	
	@OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "login")
	private Profile profile;
	
	@OneToMany(targetEntity = Basket.class,
			mappedBy = "id",  orphanRemoval = false, 
			fetch = FetchType.LAZY)
	private Set<Basket> basket;
	
}
