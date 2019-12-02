package org.packt.springboot22.vid03;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.packt.springboot22.vid03.model.Profile;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class ProfileServiceMockTest {
	
	@Test
	public void testRestTemplateHateOas() throws URISyntaxException {
		Traverson client = new Traverson(new URI("http://localhost:8080/farm/signup"), 
				           MediaTypes.HAL_JSON);
		String employeesLink = client
				.follow("profiles")
				.toObject(String.class);
		System.out.println(employeesLink);
	}

	@Test
	public void testClientHateOas() throws URISyntaxException {
		Traverson client = new Traverson(new URI("http://localhost:8080/farm/signup"), 
				MediaTypes.HAL_JSON);
		ParameterizedTypeReference<CollectionModel<Profile>> 
		       resourceParameterizedTypeReference = new ParameterizedTypeReference<CollectionModel<Profile>>() {};
		CollectionModel<Profile> employees = client
				.follow("profiles")
				.toObject(resourceParameterizedTypeReference);
		employees.forEach((p)->{
			System.out.printf("%d %-30s %-20s %-20s %-20s \n", 
					p.getId(), p.getName(), p.getUsername(), p.getPassword(), p.getEmail());
		});
	}

}
