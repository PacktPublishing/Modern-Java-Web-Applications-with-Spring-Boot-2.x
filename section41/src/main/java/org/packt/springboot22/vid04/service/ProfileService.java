package org.packt.springboot22.vid04.service;

import java.util.List;

import org.packt.springboot22.vid04.model.Profile;
import org.packt.springboot22.vid04.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public List<Profile> getProfiles(){
		return profileRepository.findProfiles();
	}

}
