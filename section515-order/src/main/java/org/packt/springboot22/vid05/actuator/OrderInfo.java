package org.packt.springboot22.vid05.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderInfo {
	
	private String dbName;
	private Long numRecords;
	private String status;

}
