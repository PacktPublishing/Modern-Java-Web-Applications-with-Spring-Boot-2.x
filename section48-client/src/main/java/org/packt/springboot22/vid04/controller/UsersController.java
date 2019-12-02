package org.packt.springboot22.vid04.controller;

import org.packt.springboot22.vid04.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	    @RequestMapping("/farm/profile")
	    
	    public String index(Model model) {
	    	model.addAttribute("profile", profileRepository.findProfiles());
	        return "th_users_list";
	    }

}
