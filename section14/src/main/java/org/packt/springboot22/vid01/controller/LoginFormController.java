package org.packt.springboot22.vid01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/farm")
public class LoginFormController {
	
	@GetMapping("/login/guest")
	@ResponseBody
	public String loginGuest(@RequestParam("user") String username,
						@RequestParam("pass") String password) {
		String message = "Welcome to FarmUp, guest " + username + "!";
		return message;
	}
	
	@PostMapping("/login/auth")
	@ResponseBody
	public String loginUser(@RequestParam String username,
						@RequestParam String password) {
		String message = "Welcome to FarmUp, member " + username + "!";
		return message;
	}
	
	@GetMapping("/login/role/{user}")
	@ResponseBody
	public String validateUserRole(@PathVariable("user") String username) {
		return "User: " + username + " is an Administrator";
	}
	
	@PostMapping("/login/role/{user}/{pwd:[A-Za-z0-9@$_]{3,20}}")
	@ResponseBody
	public String generatePassphrase(@PathVariable("user") String username,
								@PathVariable("pwd") String password) {
		return new StringBuilder(String.join("",username, password))
				.reverse()
				.toString();
	}

}
