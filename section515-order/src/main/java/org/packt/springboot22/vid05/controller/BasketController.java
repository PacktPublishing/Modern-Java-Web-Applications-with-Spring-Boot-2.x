package org.packt.springboot22.vid05.controller;

import java.util.List;

import org.packt.springboot22.vid05.model.Basket;
import org.packt.springboot22.vid05.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class BasketController {
	
	@Autowired
	private BasketRepository basketRepository; 	
	
	@GetMapping(value="/farm/order/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Basket> testing() {
		log.info("GET /farm/order/list");
		return basketRepository.findAll();
	}

}
