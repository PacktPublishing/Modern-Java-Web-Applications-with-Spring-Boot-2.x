package org.packt.springboot22.vid04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login.html")
	public String loginUser(@RequestParam(name = "error", required = false) String error, 
			Model model) {
		
		try {
			if (error.equalsIgnoreCase("credential")) {
				model.addAttribute("error", "credential");
			} else if(error.equalsIgnoreCase("expired")) {
				model.addAttribute("error", "expired");
			}
		} catch (NullPointerException e) {
			model.addAttribute("error", "unknown");
		}

		return "th_login";
	}

}
