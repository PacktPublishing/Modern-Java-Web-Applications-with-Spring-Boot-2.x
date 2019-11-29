package org.packt.springboot22.vid01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farm/admin")
public class FarmerMenuController {
	
	@GetMapping("/menu")
	public String farmerMenu(ModelMap model, @ModelAttribute("username") String username, @ModelAttribute("password") String password) {
		model.addAttribute("username", username);
		return "mst_farmers_menu";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/farm/login/auth";
	}

}
