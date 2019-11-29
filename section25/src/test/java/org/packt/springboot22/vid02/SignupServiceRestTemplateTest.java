package org.packt.springboot22.vid02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.packt.springboot22.vid02.model.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class SignupServiceRestTemplateTest {
	
	@Test
	public void testGetTransactions() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "http://localhost:8082/farmservice/signup/users";
		List<Profile> response
		  = restTemplate.getForObject(fooResourceUrl, List.class);
		System.out.println(response);
	}
	
	@Test
	public void testPostTransactions() {
		RestTemplate restTemplate = new RestTemplate();
		
		Profile profile = new Profile();
		profile.setName("John Coala");
		profile.setMobile("1111111");
		profile.setEmail("jcoala@yahoo.com");
		profile.setApproved(true);
		profile.setUsername("jcoala");
		profile.setPassword("jcoala@@&$");
		HttpEntity<Profile> request = new HttpEntity<>(profile);
		String url
		  = "http://localhost:8082/farmservice/signup/user/add";
		ResponseEntity<String> response
		  = restTemplate.postForEntity(url, request, String.class, Profile.class);
		System.out.println(response.getBody());
	}
	
	@Test
	public void testPutTransactions() {
		RestTemplate restTemplate = new RestTemplate();
		
		Profile profile = new Profile();
		profile.setName("John Coala");
		profile.setMobile("90991911");
		profile.setEmail("jcoala@yahoo.com");
		profile.setApproved(true);
		profile.setUsername("jclala");
		profile.setPassword("jclala@3@3");
		HttpEntity<Profile> request = new HttpEntity<>(profile);
		String url
		  = "http://localhost:8082/farmservice//signup/user/update/full/jcoala";
		restTemplate.put(url, request,  Profile.class);
		
	}
	
	@Test
	public void testPatchTransactions() {
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		Map<String,String> reqMap = new HashMap<>();
		HttpEntity<Map<String,String>> request = new HttpEntity<>(reqMap);
		reqMap.put("name", "Jerry Ryder");
		String url
		  = "http://localhost:8082/farmservice/signup/user/update/partial/wguru";
		String response = 
				restTemplate.patchForObject(url, request, String.class);
		System.out.println(response);
	}
	
	@Test
	public void testDeleteTransaction() {
		RestTemplate restTemplate = new RestTemplate();
		String url
		  = "http://localhost:8082/farmservice/signup/user/delete/wguru";
		restTemplate.delete(url);
		
	}
	
	@Test
	public void exchangePostTransaction() {
		RestTemplate restTemplate = new RestTemplate();
		Profile profile = new Profile();
		profile.setName("Sherwin John");
		profile.setMobile("5674343");
		profile.setEmail("sjct@yahoo.com");
		profile.setApproved(true);
		profile.setUsername("sjct");
		profile.setPassword("sjct@@&$");
		HttpEntity<Profile> request = new HttpEntity<>(profile);
		
		ResponseEntity<String> response = restTemplate
				.exchange("http://localhost:8082/farmservice/signup/user/add",
							HttpMethod.POST, request, String.class);
		System.out.println(response.getBody());
	}
	
		
}
