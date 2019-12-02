package org.packt.springboot22.vid06;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid06.model.Profile;
import org.packt.springboot22.vid06.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SignupVerifyTest {

	@Autowired
	private ProfileRepository profileRepository;

	@Test
	public void testFindAllProfiles() {
		profileRepository.findAll()
		    .as(StepVerifier::create)
		    .expectNextCount(10)
		    .verifyComplete();
	}

	@Test
	public void testSaveProfile() {
		Profile p = new Profile();
		p.setId(400L);
		p.setName("Gina Gomez");
		p.setAddress("London");
		p.setEmail("ging@gmail.com");
		p.setMobile("45945894");
		p.setUsername("ging");
		p.setPassword("ging@37");
		p.setApproved(true);
		p.setBday(LocalDate.now());

		StepVerifier.create(profileRepository.save(p))
		   .consumeNextWith((profile) -> {
			   assertThat(profile.getId()).isGreaterThan(200L);
			   assertThat(profile.getName()).isEqualTo("Gina Gomez");
		}).verifyComplete();
	}

}
