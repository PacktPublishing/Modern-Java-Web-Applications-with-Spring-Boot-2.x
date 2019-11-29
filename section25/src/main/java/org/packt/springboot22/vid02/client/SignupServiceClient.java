package org.packt.springboot22.vid02.client;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.JsonbBuilder;

import org.packt.springboot22.vid02.model.Profile;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SignupServiceClient {
		
	private RestTemplate restTemplate;
	
	 public SignupServiceClient(RestTemplateBuilder restTemplateBuilder) {
	        restTemplate = restTemplateBuilder.build();
	    }
	
	public String consumeGetUserProfile(String username){
		List<Profile> result = new ArrayList<>();
		Profile profile = new Profile();
		try {
			result = 
					restTemplate.getForObject("http://localhost:8082/farmservice/signup/users/"+username, List.class);			
		}catch(Exception e) {
			return JsonbBuilder.create().toJson(profile);
		}
		return JsonbBuilder.create().toJson(result.get(0));
	}

}
