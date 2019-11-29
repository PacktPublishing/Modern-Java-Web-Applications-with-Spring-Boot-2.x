package org.packt.springboot22.vid01.controller;

import org.packt.springboot22.vid01.model.ProfileForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farm/users/profile")
public class UserProfileFormController {
	
	@GetMapping
	public String initForm(Model model) {
		model.addAttribute("username", "sjctrags");
		model.addAttribute("profileForm", new ProfileForm());
		return "th_users_profile";
	}
	
	@PostMapping
	public String submitForm(Model model) {
		model.addAttribute("username", "sjctrags");
		
		return "th_users_profile";
	}

}
