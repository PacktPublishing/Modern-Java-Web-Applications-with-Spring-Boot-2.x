package org.packt.springboot22.vid01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farm")
public class IndexController {
	
	@Autowired
	private String webmaster;
	
	@GetMapping
	public String welcome(Model model) {
		model.addAttribute("banner", "Welcome to FarmUp!\n"
				+ "Let us manage, harvest, and enjoy our gains!");
		model.addAttribute("webmaster", webmaster);
		return "th_index";
	}

}
