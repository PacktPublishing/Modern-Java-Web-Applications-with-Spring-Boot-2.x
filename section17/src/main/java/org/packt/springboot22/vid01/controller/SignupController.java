package org.packt.springboot22.vid01.controller;

import org.packt.springboot22.vid01.exception.SignupFormException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/farm/signup")
public class SignupController {
	
	@GetMapping
	public String initForm() {
		return "th_signup";
	}
	
	
	@PostMapping
	public RedirectView submitForm(@RequestParam String name, @RequestParam String mobile,
			@RequestParam String address, @RequestParam String role, @RequestParam String username,
			@RequestParam String password) throws SignupFormException{
		
		if(username.length() == 0 || username == null) {
			throw new SignupFormException();
		}
		return new RedirectView("/farm/login/auth");
	}

}
