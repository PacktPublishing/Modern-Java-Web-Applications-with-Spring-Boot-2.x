package org.packt.springboot22.vid06.controller;

import org.packt.springboot22.vid06.model.Profile;
import org.packt.springboot22.vid06.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ProfileController {
	
	
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@GetMapping(value = "/farm/profile/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Profile> getProfileList(){
		return profileRepository.findAll();
	}

}
