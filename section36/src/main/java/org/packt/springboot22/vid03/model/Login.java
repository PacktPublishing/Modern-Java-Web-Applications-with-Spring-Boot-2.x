package org.packt.springboot22.vid03.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "login")
@Data
public class Login extends RepresentationModel<Login> {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="passphrase")
	private String passphrase;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	//@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private Profile profile;
	
}
