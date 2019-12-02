package org.packt.springboot22.vid07.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.r2dbc.query.Criteria.*;

import org.packt.springboot22.vid07.model.Harvest;

@Repository
public class HarvestRepository {
	
	@Autowired
	private DatabaseClient client;
	
	@Autowired
	private TransactionalOperator tx;
	
	public Flux<Harvest> getAllHarvest(){
		 return client.select()
				 .from(Harvest.class)
				 .orderBy(Sort.by(Order.desc("id")))
				 .as(Harvest.class)
			     .all();
	}
	
	public Flux<Harvest> getHarvest(Long id){
		 return client.select()
				 .from(Harvest.class)
				 .matching(where("id").is(id))
				 .orderBy(Sort.by(Order.desc("id")))
				 .as(Harvest.class)
			     .all();
	}
	
	public Mono<Void> addHarvest(Harvest harvest){
		return client.insert()
				.into(Harvest.class)
				.using(harvest)
				.then()
				.as(tx::transactional);
	}
	
	public Mono<Void> delHarvest(Long id){
		return client.delete()
				.from(Harvest.class)
				.matching(where("id").is(id))
				.then()
				.as(tx::transactional);
	}

}
