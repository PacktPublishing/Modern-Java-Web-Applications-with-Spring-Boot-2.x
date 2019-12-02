package org.packt.springboot22.vid06;

import java.time.LocalDate;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid06.model.Profile;
import org.packt.springboot22.vid06.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class Section61ApplicationTests {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Test
	public void testAddProfile() {
		Profile p = new Profile();
		p.setId(200L);
		p.setName("Jean Grey");
		p.setAddress("Makati");
		p.setEmail("jgrey@gmail.com");
		p.setMobile("45945894");
		p.setUsername("jeangrey");
		p.setPassword("grey");
		p.setApproved(true);
		p.setBday(LocalDate.now());
		System.out.println(p.getId());
		
		profileRepository.save(p).block();
		profileRepository.findAll().subscribe((profile)->{
			System.out.println(profile.getName());
		});
	}
}
