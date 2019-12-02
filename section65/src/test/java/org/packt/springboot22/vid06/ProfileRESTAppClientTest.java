package org.packt.springboot22.vid06;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid06.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProfileRESTAppClientTest {
	
	@Autowired
	private WebClient client;
	
	@Test
	public void testGetAllProfiles() {
		Flux<Profile> data =client.get()
				.uri("/farm/profile/list")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Profile.class);
		data.toIterable().forEach((profile) ->{
			System.out.println(profile.getName());
		});
	}
	
	@Test
	public void testSaveProfile() {
		
		Profile p = new Profile();
		p.setId(880L);
		p.setName("Gina Gomez");
		p.setAddress("London");
		p.setEmail("ging@gmail.com");
		p.setMobile("45945894");
		p.setUsername("ging");
		p.setPassword("ging@37");
		p.setApproved(true);
		p.setBday(LocalDate.now());
		
		Mono<Profile> profile = client
				.post()
				.uri("/farm/profile/save")
				.body(BodyInserters.fromValue(p))
				.retrieve()
				.bodyToMono(Profile.class);
		
		Profile result  = profile.block();
		System.out.println(result.getName());
	}

}
