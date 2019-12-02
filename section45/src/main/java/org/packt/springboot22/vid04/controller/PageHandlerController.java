package org.packt.springboot22.vid04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageHandlerController {
	
	@GetMapping("/access_denied.html")
	public String accessDenied() {
		return "th_auth_access_denied";
	}
	
	@GetMapping("/session_invalid.html")
	public String handleSessions() {
		return "th_session_invalid";
	}
	
	@GetMapping("/session_expired.html")
	public String handleExpireSessions() {
		return "th_session_expired";
	}

}
