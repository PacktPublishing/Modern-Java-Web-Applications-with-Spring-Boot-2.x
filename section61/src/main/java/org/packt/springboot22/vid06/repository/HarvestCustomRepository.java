package org.packt.springboot22.vid06.repository;

public interface HarvestCustomRepository {
	
	public void updateQtyPrice(Long id, float newPrice, int newQty);

}
