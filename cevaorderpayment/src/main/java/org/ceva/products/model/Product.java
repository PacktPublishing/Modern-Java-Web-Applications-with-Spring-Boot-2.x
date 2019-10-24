package org.ceva.products.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	private Long id;
	private String name;
	private Integer stock;
	private Float price;
		
	@OneToMany(targetEntity = OrderProduct.class,
			mappedBy = "id",  orphanRemoval = false, 
			fetch = FetchType.LAZY)
	private Set<OrderProduct> orders;

}
