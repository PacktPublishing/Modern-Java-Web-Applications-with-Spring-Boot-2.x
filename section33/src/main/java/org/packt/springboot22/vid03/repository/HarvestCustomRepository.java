package org.packt.springboot22.vid03.repository;

public interface HarvestCustomRepository {
	
	public void updateQtyPrice(Long id, float newPrice, int newQty);

}
