package org.packt.springboot22.vid01.controller;

import java.util.ArrayList;
import java.util.List;

import org.packt.springboot22.vid01.model.HarvestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farm/harvest")
public class HarvestController {
	
	private List<HarvestForm> dbHarvest = new ArrayList<>();
	
	@Autowired
	private String projectName;
	
	@GetMapping("/list")
	public String listHarvest(Model model) {
		model.addAttribute("projName", projectName);
		model.addAttribute("header", "List of Harvest");
		HarvestForm h1 = new HarvestForm();
		h1.setId(1);
		h1.setName("Tomato");
		h1.setPrice(300.50F);
		h1.setQty(100);
		h1.setLocation("SM Light");
		h1.setType("Fruit");
		h1.setDeliveryDate("June 22, 2020");
		h1.setDescription("White fruits...");
		h1.setStatus("true");
		h1.setOwner("Sherwin");
		
		dbHarvest.add(h1);
		model.addAttribute("harvest", dbHarvest);
		return "ftl_harvest_list";
	}

}
