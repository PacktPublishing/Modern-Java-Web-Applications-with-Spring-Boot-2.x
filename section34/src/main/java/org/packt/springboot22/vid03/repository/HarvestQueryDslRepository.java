package org.packt.springboot22.vid03.repository;

import org.packt.springboot22.vid03.model.Harvest;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface HarvestQueryDslRepository extends CrudRepository<Harvest, Long>, QuerydslPredicateExecutor<Harvest>, HarvestCustomDslSupport{
	
	
}
