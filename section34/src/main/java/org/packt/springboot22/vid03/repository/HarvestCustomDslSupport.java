package org.packt.springboot22.vid03.repository;

import java.util.List;

import org.packt.springboot22.vid03.model.Harvest;
import org.packt.springboot22.vid03.model.QHarvest;

public interface HarvestCustomDslSupport {
	public List<Harvest> findByName(String name);
	List<QHarvest> getAllHarvest(long id);
}
