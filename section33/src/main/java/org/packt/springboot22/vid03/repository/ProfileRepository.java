package org.packt.springboot22.vid03.repository;

import org.packt.springboot22.vid03.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, Long>{
	
		
	
}
