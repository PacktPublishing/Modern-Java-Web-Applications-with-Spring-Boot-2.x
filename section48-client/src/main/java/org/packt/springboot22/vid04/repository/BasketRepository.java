package org.packt.springboot22.vid04.repository;

import java.util.List;

import org.packt.springboot22.vid04.model.Basket;
import org.packt.springboot22.vid04.model.OrderReceipt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket,Long>{
	
	@Query("SELECT new org.packt.springboot22.vid04.model.OrderReceipt(b.id, b.qty, h.id, h.name, h.price) "
			+ "FROM Basket b INNER JOIN b.harvest h")
	List<OrderReceipt> fetchHarvestBasketInnerJoin();
	
	@Query("SELECT new org.packt.springboot22.vid04.model.OrderReceipt(b.id, b.qty, h.id, h.name, h.price) "
			+ "FROM Basket b RIGHT JOIN b.harvest h")
	List<OrderReceipt> fetchHarvestBasketRightJoin();
	
	
	
}
