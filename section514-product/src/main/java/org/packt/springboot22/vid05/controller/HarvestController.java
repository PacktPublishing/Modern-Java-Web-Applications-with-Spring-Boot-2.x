package org.packt.springboot22.vid05.controller;

import java.util.List;

import org.packt.springboot22.vid05.model.Harvest;
import org.packt.springboot22.vid05.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class HarvestController {
	
	@Autowired
	private HarvestRepository harvestRepository;
	
	@GetMapping(value = "/farm/harvest/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Harvest> getHarvestList(){
		log.info("GET /farm/harvest/list");
		return harvestRepository.findAll();
	}
	
    @HystrixCommand(fallbackMethod = "fallbackGetHarvest")
	@GetMapping(value = "/farm/harvest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Harvest getHarvest(@PathVariable("id") long id) {
		log.info("GET /farm/harvest/" + id);
		Harvest harvest = harvestRepository.getOne(id);
		return harvest;
	}
	
	public Harvest fallbackGetHarvest(long id) {
		log.info("fallback GET /farm/harvest/" + id);
		System.out.println("fallback GET /farm/harvest/" + id);
		return new Harvest();
	}

}
