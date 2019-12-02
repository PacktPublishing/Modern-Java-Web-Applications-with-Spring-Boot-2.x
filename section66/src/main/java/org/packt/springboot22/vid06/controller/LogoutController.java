package org.packt.springboot22.vid06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	
	@GetMapping("/logout.html")
	public String logoutUser() {
		return "th_logout";
	}

}
