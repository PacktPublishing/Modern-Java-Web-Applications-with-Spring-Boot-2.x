package org.packt.springboot22.vid07.controller;

import java.util.List;

import org.packt.springboot22.vid07.model.Profile;
import org.packt.springboot22.vid07.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.extern.log4j.Log4j2;

@Timed("profile")
@RestController
@CrossOrigin
@Log4j2
public class UsersController {
	
		@Autowired
		private ProfileRepository profileRepository;
	
	    @GetMapping(value ="/farm/profile/list", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Profile> getUserList() {
	    	log.info("GET /farm/profile/list");
	    	return profileRepository.findProfiles();
	    }
	    
	    @GetMapping(value ="/farm/profile/add", produces = MediaType.APPLICATION_JSON_VALUE)
	    public Profile addProfile(@RequestBody Profile profile) {
	    	log.info("GET /farm/profile/add");
	    	profileRepository.save(profile);
	    	return profile;
	    }

}
