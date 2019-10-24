package org.ceva.products.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payment_product")
public class PaymentProduct {

	@Id
	private Long id;
	private Long orderId;
	private Double totalAmount;
	private Double totalDue;
}
