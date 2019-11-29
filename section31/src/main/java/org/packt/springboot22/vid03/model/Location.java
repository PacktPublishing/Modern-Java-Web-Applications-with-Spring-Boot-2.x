package org.packt.springboot22.vid03.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "location")
@Data
public class Location {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="delivery_date")
	private LocalDate deliveryDate;
	
	@Column(name="owner")
	private String owner;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "hid", nullable = false)
	private Harvest harvest;

}
