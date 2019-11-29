package org.packt.springboot22.vid03.repository;

import java.util.List;

import org.packt.springboot22.vid03.model.Harvest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface HarvestRepository extends MongoRepository<Harvest, Long>, HarvestCustomRepository {
	
	@Query("{'price' : {$gt : ?0}}")
	public List<Harvest> findByLeastPrice(float basePrice);
	
	@Query("{'qty' : {$gt : ?0}}")
	public List<Harvest> findByNames(int qty);
	
	@Query(value = "{'status' : ?0}", delete = true)
	public void deleteByStatus(String status);
	
	
	
	
	
	
}
