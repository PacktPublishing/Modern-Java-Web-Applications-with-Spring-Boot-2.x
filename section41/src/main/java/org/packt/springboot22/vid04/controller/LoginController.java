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
			if (error.equalsIgnoreCase("true"))
					model.addAttribute("error", true);
		} catch (NullPointerException e) {
			model.addAttribute("error", false);
		}

		return "th_login";
	}

}
