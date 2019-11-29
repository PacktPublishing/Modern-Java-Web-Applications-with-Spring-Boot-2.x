package org.packt.springboot22.vid01.controller;

import java.time.LocalDate;
import java.util.List;

import org.packt.springboot22.vid01.model.Harvest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/farm/harvest/add")
public class HarvestFormController {
	
	@Autowired
	private String projectName;
	
	@Autowired
	private LocalDate localDate;
	
	@Autowired
	private List<Harvest> dbHarvest;
	
	@GetMapping
	public String initForm(Model model) {
		model.addAttribute("projName", projectName);
		
		return "harvest_form";
	}
	
	@PostMapping
	public String submitForm(Model model, @RequestParam String name,
					@RequestParam Integer qty, 
					@RequestParam Float price) {
		model.addAttribute("projName", projectName);
		model.addAttribute("ldate", localDate);
		Harvest prod = new Harvest();
		prod.setName(name);
		prod.setQty(qty);
		prod.setPrice(price);
		
		dbHarvest.add(prod);
		model.addAttribute("dbHarvest", dbHarvest);
		return "harvest_list";
	}

}
