package org.packt.springboot22.vid06.model;

import lombok.Data;

@Data
public class OrderReceipt {
			
	public OrderReceipt(Long bid, Integer qty, Long hid, String harvestName, Float price) {
		super();
		this.bid = bid;
		this.qty = qty;
		this.hid = hid;
		this.harvestName = harvestName;
		this.price = price;
	}
	private Long bid;
	private Integer qty;
	private Long hid;
	private String harvestName;
	private Float price;
	

}
