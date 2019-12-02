package org.packt.springboot22.vid06.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "location")
public class Location {

	@Id
	private Long id;
	private String name;
	private LocalDate deliveryDate;
	private String owner;
	private Long hid;

}
