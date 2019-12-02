package org.packt.springboot22.vid06.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
	
	@Id
	private Long id;
	private Long userid;
	private Long hid;
	private Integer qty;
	private LocalDate purchasedDate;
	private String approvedBy;
	private LocalDate approvedDate;
	
	

}
