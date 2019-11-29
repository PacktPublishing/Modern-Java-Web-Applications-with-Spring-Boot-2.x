package org.packt.springboot22.vid03.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Harvest {

	private Long id;
	private String name;
	private Integer qty;
	private Float price;
	private String description;
	private String status;
	private String type;
	private LocalDate approvedDate;

}
