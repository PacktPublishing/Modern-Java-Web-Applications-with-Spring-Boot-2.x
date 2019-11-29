package org.packt.springboot22.vid02.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Harvest {

	private Integer id;
	private String name;
	private Integer qty;
	private Float price;
	private String location;
	private String description;
	private String status;
	private LocalDate deliveryDate;
	private String type;
	private String owner;

}
