package org.packt.springboot22.vid06.repository;

import org.packt.springboot22.vid06.model.Login;
import org.packt.springboot22.vid06.model.Profile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface ProfileRepository extends ReactiveCrudRepository<Profile, Long>{
	
	public Mono<Login> findByUsername(String username);
	
}
