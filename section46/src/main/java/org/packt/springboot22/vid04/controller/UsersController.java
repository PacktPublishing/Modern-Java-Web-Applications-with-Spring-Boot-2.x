package org.packt.springboot22.vid04.controller;

import java.util.List;

import org.packt.springboot22.vid04.model.Profile;
import org.packt.springboot22.vid04.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UsersController {
	
		@Autowired
		private ProfileRepository profileRepository;
	
	    @GetMapping(value ="/farm/profile/list", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Profile> getUserList() {
	    	return profileRepository.findProfiles();
	    }
	    
	    @GetMapping(value ="/farm/profile/add", produces = MediaType.APPLICATION_JSON_VALUE)
	    public Profile addProfile(@RequestBody Profile profile) {
	    	profileRepository.save(profile);
	    	return profile;
	    }

}
