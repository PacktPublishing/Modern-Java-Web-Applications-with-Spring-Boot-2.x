package org.packt.springboot22.vid06.controller;

import java.time.Duration;
import java.util.Random;

import org.packt.springboot22.vid06.model.Profile;
import org.packt.springboot22.vid06.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sse")
public class ProfileSSEMessageController {
	
	@Autowired
	private ProfileRepository profileRepository;

	@GetMapping("/profile-names")
	public Flux<ServerSentEvent<String>> random() {
		Random random = new Random(100);
		return profileRepository.findAll().map(profile -> profile.getName())
		   .map(name -> {
			   	return ServerSentEvent.<String>builder()
					.event("profile-send")
					.id(random.nextInt()+"")
					.data(name)
					.build();
		}).delayElements(Duration.ofSeconds(1));
	}
	
	@GetMapping("/profile-send")
	public Flux<ServerSentEvent<Profile>> sendProfile(){
		return profileRepository.findAll().map(profile -> {
			return ServerSentEvent.<Profile>builder()
					.event("profile-send")
					.id(profile.getId().toString())
					.data(profile)
					.build();
		}).delayElements(Duration.ofSeconds(1));
	}

}
