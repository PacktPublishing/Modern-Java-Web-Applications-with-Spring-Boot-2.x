package org.packt.springboot22.vid03;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid03.model.Profile;
import org.packt.springboot22.vid03.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class SignupServiceMockTest {
	
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
		
		profileRepository.insert(p);
		System.out.println(profileRepository.findAll());
	}
	
	

	
}
