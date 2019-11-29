package org.packt.springboot22.vid01.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@Autowired
	private String webmaster;
	
	@GetMapping("/farm/users")
	public String listUsers(Model model) {
		model.addAttribute("users", Arrays.asList("sjctrags", "root", "guest"));
		model.addAttribute("webmaster", webmaster);
		return "mst_users_list";
	}
	
	@GetMapping("/farm/guests")
	public String listGuests(Model model) {
		model.addAttribute("users", Arrays.asList("sjctrags", "root", "guest"));
		return "tpl_guest_list";
	}
	
	@GetMapping("/farm/providers")
	public String listProviders(Model model) {
		model.addAttribute("users", Arrays.asList("sjctrags", "root", "guest"));
		return "th_providers";
	}


}
