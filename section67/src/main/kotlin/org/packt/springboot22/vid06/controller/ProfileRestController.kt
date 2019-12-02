package org.packt.springboot22.vid06.controller

import org.packt.springboot22.vid06.repository.ProfileRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import org.packt.springboot22.vid06.model.Profile
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping("/farm")
class ProfileRestController {
	
	@Autowired
	lateinit var profileRepository : ProfileRepository;
	
	@GetMapping("/profile/list")
    fun findAllProfiles() : Flux<Profile> = profileRepository.findAll()
}