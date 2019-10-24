package org.ceva.products.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Data
@Entity
@Table(name = "order_product")
public class OrderProduct {
	
	@Id
	private Long id;
	private Long pid;
	private Integer qty;
	private Double amount;
	private Long orderId;
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid", insertable = false,  updatable = false)
	@Fetch(FetchMode.JOIN)
	private Product product;
	
	
}
