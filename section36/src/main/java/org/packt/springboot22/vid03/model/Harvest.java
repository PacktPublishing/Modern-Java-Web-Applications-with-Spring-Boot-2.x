package org.packt.springboot22.vid03.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table(name = "harvest")
public class Harvest extends RepresentationModel<Harvest>{

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="qty")
	private Integer qty;
	
	@Column(name="price")
	private Float price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column(name="type")
	private String type;
	
	@Column(name="approved")
	private LocalDate approvedDate;

}
