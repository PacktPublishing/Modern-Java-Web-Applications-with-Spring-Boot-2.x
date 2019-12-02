package org.packt.springboot22.vid07.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Harvest {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private Integer qty;
	private Float price;
	private String description;
	private String status;
	private String type;
	@Column(value="approved")
	private LocalDate approvedDate;
	
	

}
