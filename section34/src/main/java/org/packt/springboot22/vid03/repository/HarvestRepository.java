package org.packt.springboot22.vid03.repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.packt.springboot22.vid03.model.Harvest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepository extends JpaRepository<Harvest, Long>{

	public Iterable<Harvest> findByNameLike(String expr);
	public List<Harvest> findByNameIs(String expr);
	public List<Harvest> findByApprovedDateAfter(LocalDate startDate);
	public List<Harvest> findByApprovedDateBetween(LocalDate startDate, LocalDate endDate);
	public Stream<Harvest> findByQtyGreaterThan(int items);
	public Stream<Harvest> findByPriceGreaterThanEqual(float basePrice);
	public Stream<Harvest> findByPriceIn(Collection<Float> prices);
    
	Page<Harvest> queryFirst10ByPrice(float price, Pageable pageable);
	Slice<Harvest> findTop3ByQty(int qty, Pageable pageable);
	
	Page<Harvest> findByStatus(boolean status, Pageable pageable);
	Slice<Harvest> findByType(String type, Pageable pageable);
	List<Harvest> findByPrice(float price, Sort sort);
}
