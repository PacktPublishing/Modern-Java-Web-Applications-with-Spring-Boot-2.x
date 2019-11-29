package org.packt.springboot22.vid01.model;

import lombok.Data;

@Data
public class HarvestForm {

	private Integer id;
	private String name;
	private Integer qty;
	private Float price;
	private String location;
	private String description;
	private String status;
	private String deliveryDate;
	private String type;
	private String owner;

}
