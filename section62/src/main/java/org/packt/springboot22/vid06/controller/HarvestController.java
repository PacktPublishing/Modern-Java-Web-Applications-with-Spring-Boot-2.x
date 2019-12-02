package org.packt.springboot22.vid06.controller;

import org.packt.springboot22.vid06.model.Harvest;
import org.packt.springboot22.vid06.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/farm")
public class HarvestController {
	
	@Autowired
	private HarvestRepository harvestRepository;
		
		
	@GetMapping("/harvest/list")
	public String listHarvest(Model model) {
		Flux<Harvest> harvestList = harvestRepository.findAll();
		model.addAttribute("harvest", harvestList);
		return "ftl_harvest_list";
	}

}
