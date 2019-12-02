package org.packt.springboot22.vid03.repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.packt.springboot22.vid03.model.Harvest;
import org.springframework.data.repository.CrudRepository;

public interface HarvestRepository extends CrudRepository<Harvest, Long>{

	public Iterable<Harvest> findByNameLike(String expr);
	public List<Harvest> findByNameIs(String expr);
	public List<Harvest> findByApprovedDateAfter(LocalDate startDate);
	public List<Harvest> findByApprovedDateBetween(LocalDate startDate, LocalDate endDate);
	public Stream<Harvest> findByQtyGreaterThan(int items);
	public Stream<Harvest> findByPriceGreaterThanEqual(float basePrice);
	public Stream<Harvest> findByPriceIn(Collection<Float> prices);
}
