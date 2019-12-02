package org.packt.springboot22.vid06.controller;

import java.time.Duration;

import org.packt.springboot22.vid06.model.Harvest;
import org.packt.springboot22.vid06.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HarvestController {
	
	@Autowired
	private HarvestRepository harvestRepository;
	
		
	@GetMapping(value = "/farm/harvest/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Harvest> getHarvestList(){
		return harvestRepository.findAll().delayElements(Duration.ofMillis(100));
	}
	
	@GetMapping(value = "/farm/harvest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Harvest> getHarvest(@PathVariable("id") Long id){
		return harvestRepository.findById(id);
	}
	
	@PostMapping(value = "/farm/harvest/add", 
			produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Harvest> addHarvest(@RequestBody Harvest harvest){
		harvestRepository.save(harvest).delaySubscription(Duration.ofMillis(100));
		return Mono.just(harvest);
		
	}
	
	@DeleteMapping(value = "/farm/harvest/delete/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Void> delHarvest(@PathVariable("id") Long id){
		return harvestRepository.deleteById(id);
	}
	
	

}
