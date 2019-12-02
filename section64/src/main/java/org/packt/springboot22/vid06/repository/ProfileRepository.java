package org.packt.springboot22.vid06.repository;

import org.packt.springboot22.vid06.model.Profile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends ReactiveCrudRepository<Profile, Long> {
	
}
