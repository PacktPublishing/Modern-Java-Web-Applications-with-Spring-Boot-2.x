package org.packt.springboot22.vid03.service;

import java.util.List;

import org.packt.springboot22.vid03.model.Profile;
import org.packt.springboot22.vid03.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public boolean addProfile(Profile profile) {
		profileRepository.save(profile);
		return false;
	}
	
	public List<Profile> getProfiles() {
		return profileRepository.findProfiles();
	}
}
