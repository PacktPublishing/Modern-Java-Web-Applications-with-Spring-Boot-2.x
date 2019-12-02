package org.packt.springboot22.vid06.repository;

import org.packt.springboot22.vid06.model.Harvest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface HarvestRepository extends ReactiveMongoRepository<Harvest, Long>, HarvestCustomRepository {
	
	@Query("{'price' : {$gt : ?0}}")
	public Flux<Harvest> findByLeastPrice(float basePrice);
	
	@Query("{'qty' : {$gt : ?0}}")
	public Flux<Harvest> findByNames(int qty);
	
	@Query(value = "{'status' : ?0}", delete = true)
	public void deleteByStatus(String status);
	
	
	
	
	
	
}
