package org.packt.springboot22.vid04.controller;

import java.time.LocalDate;

import org.packt.springboot22.vid04.model.Harvest;
import org.packt.springboot22.vid04.model.Location;
import org.packt.springboot22.vid04.model.form.HarvestForm;
import org.packt.springboot22.vid04.repository.HarvestRepository;
import org.packt.springboot22.vid04.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasRole('ADMIN ADD')")
@RequestMapping("/farm/harvest/add")
public class HarvestFormController {
	
	@Autowired
	private HarvestRepository harvestRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping
	public String initForm(Model model){
				model.addAttribute("harvestForm", new HarvestForm());
		return "th_harvest_form";
	}
	
	@PostMapping
	public String submitForm(Model model, @ModelAttribute("harvestForm") HarvestForm harvestForm) {
				
		Harvest harvest = new Harvest();
		harvest.setId(harvestForm.getId());
		harvest.setName(harvestForm.getName());
		harvest.setApprovedDate(harvestForm.getApprovedDate());
		harvest.setQty(harvestForm.getQty());
		harvest.setPrice(harvestForm.getPrice());
		harvest.setDescription(harvestForm.getDescription());
		harvest.setStatus(harvestForm.getStatus());
		harvest.setType(harvestForm.getType());
		
		Location location = new Location();
		location.setDeliveryDate(LocalDate.now());
		location.setHid(harvestForm.getId());
		location.setId(harvestForm.getId()+100);
		location.setName(harvestForm.getLocation());
		location.setOwner(harvestForm.getOwner());
		
		harvestRepository.save(harvest);
		locationRepository.save(location);
		
		model.addAttribute("harvest", harvestRepository.findAll());
		return "th_harvest_list";
	}

}
