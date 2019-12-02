package org.packt.springboot22.vid06.repository;

import org.packt.springboot22.vid06.model.Login;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface LoginRepository extends ReactiveCrudRepository<Login, Long>{

	public Mono<Login> findByUsername(String username);
}

