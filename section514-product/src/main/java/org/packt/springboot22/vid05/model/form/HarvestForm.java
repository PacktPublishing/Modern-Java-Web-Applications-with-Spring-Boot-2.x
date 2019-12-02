package org.packt.springboot22.vid05.model.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class HarvestForm {

	private Long id;
	private String name;
	private Integer qty;
	private Float price;
	private String location;
	private String description;
	private String status;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate approvedDate;
	private String type;
	private String owner;

}
