package org.packt.springboot22.vid04.controller;

import java.util.List;
import java.util.Optional;

import org.packt.springboot22.vid04.model.Harvest;
import org.packt.springboot22.vid04.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HarvestController {
	
	@Autowired
	private HarvestRepository harvestRepository;
	
	@GetMapping(value = "/farm/harvest/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Harvest> getHarvestList(){
		
		return harvestRepository.findAll();
	}
	
	@GetMapping(value = "/farm/harvest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Harvest getHarvest(@PathVariable("id") long id) {
		Harvest harvest = Optional.ofNullable(new Harvest()).orElse(harvestRepository.getOne(id));
		return harvest;
	}

}
