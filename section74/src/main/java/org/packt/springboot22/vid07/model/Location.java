package org.packt.springboot22.vid07.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private LocalDate deliveryDate;
	private String owner;
	private Long hid;
	
}
