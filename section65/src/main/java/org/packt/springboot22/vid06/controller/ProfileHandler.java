package org.packt.springboot22.vid06.controller;

import org.packt.springboot22.vid06.model.Profile;
import org.packt.springboot22.vid06.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class ProfileHandler {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	 public Mono<ServerResponse> getUsers(ServerRequest request) {
	        return ok().contentType(MediaType.APPLICATION_JSON)
	                .body(fromPublisher(profileRepository.findAll(), Profile.class));
	    }
	 
	 public Mono<ServerResponse> saveProfile(ServerRequest request) {
	        Mono<Profile> user = request.bodyToMono(Profile.class);
	        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
	                .body(fromPublisher(user.flatMap(profileRepository::save), Profile.class));
	    }

}
