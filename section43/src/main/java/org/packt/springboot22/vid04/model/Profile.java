package org.packt.springboot22.vid04.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@NamedQuery(name = "Profile.findByFirstName", query = "FROM Profile WHERE name = ?1")
@Table(name = "signup")
@Data
public class Profile {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="approved")
	private boolean approved;
	
	@Column(name="birthday", columnDefinition = "DATE")
	private LocalDate bday;
	
	@OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "profile")
	private Login login;

}
