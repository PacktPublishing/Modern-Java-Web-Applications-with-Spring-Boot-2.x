package org.packt.springboot22.vid03.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.packt.springboot22.vid03.model.Login;
import org.packt.springboot22.vid03.model.Profile;
import org.packt.springboot22.vid03.repository.LoginRepository;
import org.packt.springboot22.vid03.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/farm", produces = "application/hal+json")
public class ProfileController {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping(value="/signup", produces = "application/hal+json")
	public HttpEntity<CollectionModel<Profile>> getAllProfiles() {
		for(Profile p : profileRepository.findAll()) {
			Link linkSelf = linkTo(methodOn(ProfileController.class).getProfile(p.getId())).withRel("profile");
			Link linkRel= linkTo(methodOn(ProfileController.class).getAllLogin(p.getUsername())).withRel("login");
			
			p.add(linkSelf);
			p.add(linkRel);
		}
		CollectionModel<Profile> model = new CollectionModel<>(profileRepository.findAll());
		Link link = linkTo(methodOn(ProfileController.class).getAllProfiles()).withRel("profiles");
		model.add(link);
		
		HttpEntity<CollectionModel<Profile>> entity = new HttpEntity<CollectionModel<Profile>>(model);
		return entity;
	}
	
	@GetMapping(value="/signup/{id}", produces = "application/hal+json")
	public HttpEntity<EntityModel<Profile>> getProfile(@PathVariable Long id){
		Profile p = profileRepository.findProfile(id);
		EntityModel<Profile> model = new EntityModel<Profile>(p);
		Link linkSelf = linkTo(methodOn(ProfileController.class).getProfile(p.getId())).withSelfRel();
		Link linkRel= linkTo(methodOn(ProfileController.class).getAllLogin(p.getUsername())).withRel("login");
		model.add(linkSelf);
		model.add(linkRel);
		
		HttpEntity<EntityModel<Profile>> entity = new HttpEntity<EntityModel<Profile>>(model);
		
		return entity;
	}
	
	@PostMapping(value="/signup/add", consumes= MediaType.APPLICATION_JSON_VALUE, produces = "application/hal+json")
	public HttpEntity<EntityModel<Profile>> addProfile(@RequestBody Profile profile){
	
		profileRepository.save(profile);
		EntityModel<Profile> model = new EntityModel<Profile>(profile);
		Link link = linkTo(methodOn(ProfileController.class).addProfile(profile)).slash(profile.getId()).withRel("addprofile");
		model.add(link);
		
		HttpEntity<EntityModel<Profile>> entity = new HttpEntity<EntityModel<Profile>>(model);
		return entity;
	}
	
	@GetMapping(value="/signup/login/{username}", produces = "application/hal+json")
	public HttpEntity<CollectionModel<Login>> getAllLogin(@PathVariable String username){
		for(Login l : loginRepository.findByUsername(username)) {
			Link link = linkTo(methodOn(ProfileController.class).getProfile(l.getProfile().getId())).withRel("profile");
			l.add(link);
		}
		CollectionModel<Login> model = new CollectionModel<Login>(loginRepository.findByUsername(username));
		Link link = linkTo(methodOn(ProfileController.class).getAllLogin(username)).withSelfRel();
		model.add(link);
		
		HttpEntity<CollectionModel<Login>> entity = new HttpEntity<CollectionModel<Login>>(model);
		return entity;
	}

}
