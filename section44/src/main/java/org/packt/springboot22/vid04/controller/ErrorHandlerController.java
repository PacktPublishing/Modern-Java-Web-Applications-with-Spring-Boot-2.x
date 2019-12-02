package org.packt.springboot22.vid04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandlerController {
	
	@GetMapping("/access_denied.html")
	public String accessDenied() {
		return "th_auth_access_denied";
	}

}
