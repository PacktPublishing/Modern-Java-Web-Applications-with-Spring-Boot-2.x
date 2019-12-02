package org.packt.springboot22.vid06.controller;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.packt.springboot22.vid06.model.Profile;
import org.packt.springboot22.vid06.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ProfileHandler {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public Mono<ServerResponse> profileResource(ServerRequest request) {
		Map<String,Object> models = new HashMap<>();
		models.put("profile", profileRepository.findAll());
        return ServerResponse.ok()
                .render("th_users_list", models);
    }
	
	public Mono<ServerResponse> saveProfileGet(ServerRequest request) {
        return ServerResponse.ok()
                .render("th_signup");
	}
	
	public Mono<ServerResponse> saveProfilePost(ServerRequest request) {
	        Mono<MultiValueMap<String,String>> user = request.formData();
	        
	        Function<MultiValueMap<String,String>, Map<String, String>> 
	                convertToMap = (form) -> {
	        	Map<String, String> params = form.toSingleValueMap();
	        	return params;
	        };
	        
	        Function<Map<String, String>, Profile> convertToProfile = (params) -> {
	        	Profile profile = new Profile();
	        	profile.setId(Long.parseLong(params.get("id")));
	        	profile.setName(params.get("name"));
	        	profile.setAddress(params.get("address"));
	        	profile.setMobile(params.get("mobile"));
	        	profile.setEmail(params.get("email"));
	        	profile.setBday(LocalDate.parse(params.get("bday").trim().strip(), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
	        	profile.setApproved(false);
	        	profile.setUsername(params.get("username"));
	        	profile.setPassword(params.get("password"));
	        	return profile;
	        };
	      
	        Map<String,Object> models = new HashMap<>();
			models.put("profile", profileRepository.findAll());
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
	                .body(fromPublisher(user.map(convertToMap).map(convertToProfile)
	                		.flatMap(profileRepository::save), Profile.class));
	   }
}
