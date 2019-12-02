package org.packt.springboot22.vid04.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	 @GetMapping("/profile/info")
	    public Principal user(Principal principal) {
		    System.out.println(principal.getName());
	        return principal;
	    }
}
