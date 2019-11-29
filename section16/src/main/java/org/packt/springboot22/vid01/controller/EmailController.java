package org.packt.springboot22.vid01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/farm/email")
public class EmailController {
	
	@GetMapping
	public String initForm() {
		return "tpl_email_form";
	}
	
	@PostMapping
	@ResponseBody
	public String submitForm(@RequestBody String email) {
		return email;
	}

}
