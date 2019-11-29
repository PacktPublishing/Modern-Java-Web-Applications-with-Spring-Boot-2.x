package org.packt.springboot22.vid01.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchFormController {
	
	@Autowired
	private String projectName;
	
	@GetMapping("/farm/search")
	public String initForm(Model model) {
		model.addAttribute("projName", projectName);
		return "search_form";
	}
	
	@PostMapping("/farm/search")
	public String submitForm(Model model, @RequestParam("keyword") String keyword) {
		model.addAttribute("projName", projectName);
		model.addAttribute("keyword", keyword);
		model.addAttribute("harvest", references());
		return "search_result";
	}
	
	public List<String> references(){
		return Arrays.asList("Apple", "Tomato", "Potato");
	}
	

}
