package org.packt.springboot22.vid02.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.validation.Valid;

import org.packt.springboot22.vid02.exception.MissingResourceException;
import org.packt.springboot22.vid02.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/signup")
@Log4j2
public class SignupController  {

	@Autowired
	private List<Profile> users;
	
	@GetMapping( value = "/users/approved", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getApprovedUsers() {
		return users.stream().filter(u-> u.isApproved() == true).collect(Collectors.toList());
	}

	@GetMapping( value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getSignedupUsers() {
		return users;
	}

	
	@GetMapping( value = "/users/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonObject getTotalUsers() {
		JsonObject data = Json.createObjectBuilder()
				.add("count", users.stream().count())
				.build();
		return data;
	}
	
	@GetMapping( value = "/users/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonArray getLoginInfo() {
		JsonArray loginData = Json.createArrayBuilder().build(); 
		JsonArrayBuilder jsonDataBuilder = Json.createArrayBuilder(loginData);
		for(Profile rec : users) {
			JsonObject jsonRow = Json.createObjectBuilder()
					.add("name", rec.getName())
					.add("username", rec.getUsername())
					.add("password", rec.getPassword())
					.build();
			jsonDataBuilder.add(jsonRow);
		}
		loginData = jsonDataBuilder.build();
		return loginData;
	}
	
	@GetMapping( value = "/users/countjson", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getJsonPTotal() {
		JsonObject jsonProd = Json.createObjectBuilder()
				.add("count", users.size())
				.build();
		return jsonProd.toString();
	}
	
    	

	@GetMapping( value = "/users/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getSignedupUser(@PathVariable String username) throws MissingResourceException {
		List<Profile> filteredUsers = users.stream().filter(u -> u.getUsername().contains(username)).collect(Collectors.toList());
		if(filteredUsers.size() == 0 || filteredUsers == null) {
			throw new MissingResourceException("missing record");
		}
		return filteredUsers;
	}

	@PostMapping( value = "/user/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewSignup(@RequestBody @Valid Profile profile) {
		users.add(profile);
		return ResponseEntity.ok("added profile");
	}

	@PostMapping( value = "/user/add/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> addNewFormSignup(@RequestParam Map<String, String> reqParams) {
		Profile profile = new Profile();
		log.info(reqParams);
		profile.setName(reqParams.getOrDefault("name", ""));
		profile.setEmail(reqParams.getOrDefault("email", ""));
		profile.setAddress(reqParams.getOrDefault("address", ""));
		profile.setMobile(reqParams.getOrDefault("mobile", ""));
		profile.setUsername(reqParams.getOrDefault("username", ""));
		profile.setPassword(reqParams.getOrDefault("password", ""));
		profile.setApproved(Boolean.parseBoolean(reqParams.getOrDefault("approved", "false")));
		users.add(profile);
		return ResponseEntity.ok("added profile");
	}

	@PutMapping( value = "/user/update/full/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateSignup(@RequestBody Profile profile, @PathVariable String username) {

		Optional.of(profile).ifPresent(prf -> { 
			users.removeIf( p -> p.getUsername().equals(username));
			users.add(profile);
		});
		return ResponseEntity.ok("updated profile");
	}

	@PatchMapping( value = "/user/update/partial/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> partialupdateSignup(@RequestBody Map<String, Object> updates, @PathVariable String username) {
	
		Profile profile = users.stream().filter(u -> u.getUsername().equals(username)).findAny().orElse(null);
		Optional.ofNullable(updates.get("username")).ifPresent( u -> {
			String user = (String) u;
			profile.setUsername(user);
		});
		Optional.ofNullable(updates.get("password")).ifPresent( p -> {
			String pass = (String) p;
			profile.setPassword(pass);
		});
		Optional.ofNullable(updates.get("name")).ifPresent( n -> {
			String name = (String) n;
			profile.setName(name);
		});
		Optional.ofNullable(updates.get("mobile")).ifPresent( m -> {
			String mobile = (String) m;
			profile.setMobile(mobile);
		});
		Optional.ofNullable(updates.get("email")).ifPresent( e -> {
			String email = (String) e;
			profile.setEmail(email);
		});
		Optional.ofNullable(updates.get("address")).ifPresent( a -> {
			String address = (String) a;
			profile.setAddress(address);
		});
		Optional.ofNullable(updates.get("approved")).ifPresent( a -> {
			boolean approved = (Boolean) a;
			profile.setApproved(approved);
		});
	
		return ResponseEntity.ok("updated profile");
	}

	@DeleteMapping( value = "/user/delete/{username}")
	public ResponseEntity<?> deleteSignup(@PathVariable String username) {
		users.removeIf( p -> p.getUsername().equals(username));
		return ResponseEntity.ok("updated profile");
	}
	
	@GetMapping( value = "/users/async", produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletionStage<List<Profile>> getAsyncListProd(){
		 CompletionStage<List<Profile>> prodCS = 
			CompletableFuture.supplyAsync(() -> {
				
				 try {
				     Thread.sleep(1000);
				 } catch (InterruptedException ex) {   }
				 
				 return users;
			});
		 return prodCS;
	}
	
	
	
	
}
