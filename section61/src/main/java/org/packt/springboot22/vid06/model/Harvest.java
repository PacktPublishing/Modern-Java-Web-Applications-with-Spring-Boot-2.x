package org.packt.springboot22.vid06.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "harvest")
public class Harvest {

	@Id
	private Long id;
	private String name;
	private Integer qty;
	private Float price;
	private String description;
	private String status;
	private String type;
	private LocalDate approvedDate;

}
