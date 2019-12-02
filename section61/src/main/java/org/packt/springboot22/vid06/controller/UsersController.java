package org.packt.springboot22.vid06.controller;

import java.time.Duration;

import org.packt.springboot22.vid06.model.Profile;
import org.packt.springboot22.vid06.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Flux;

@Controller
public class UsersController {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@GetMapping("/farm/profile/list")
	public String viewProfileList(Model model) {
	   Flux<Profile> profileList = profileRepository
			   						.findAll()
			   						.distinct()
			   						.delayElements(Duration.ofMillis(10500));
	   model.addAttribute("profile", profileList);
	   return "th_users_list";
	}
	
	

}
