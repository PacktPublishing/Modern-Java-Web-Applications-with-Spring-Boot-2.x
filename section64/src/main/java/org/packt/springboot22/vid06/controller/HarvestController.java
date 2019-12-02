package org.packt.springboot22.vid06.controller;

import org.packt.springboot22.vid06.model.Harvest;
import org.packt.springboot22.vid06.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class HarvestController {
	
	@Autowired
	private HarvestRepository harvestRepository;
	
	@GetMapping(value = "/farm/harvest/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Harvest> getHarvestList(){
		return harvestRepository.getAllHarvest();
	}

}
