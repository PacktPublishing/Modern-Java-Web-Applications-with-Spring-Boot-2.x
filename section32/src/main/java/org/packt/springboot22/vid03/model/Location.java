package org.packt.springboot22.vid03.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Location {

	private Long id;
	private String name;
	private LocalDate deliveryDate;
	private String owner;
	private Long hid;

}
