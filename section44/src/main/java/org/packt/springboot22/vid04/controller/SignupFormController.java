package org.packt.springboot22.vid04.controller;

import org.packt.springboot22.vid04.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farm/profile/add")
public class SignupFormController {

	@GetMapping
	public String initForm(Model model) {
		model.addAttribute("profileForm", new Profile());
		return "th_signup";
	}
	
	@PostMapping
	public String submitForm(Model model) {
		return "redirect:/farm/profile";
	}
}
