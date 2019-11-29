package org.packt.springboot22.vid02.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonObject;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Api(value = "Signup Controller" )
@RestController
@RequestMapping("/signup")
@Log4j2
public class SignupController  {

	@Autowired
	private List<Profile> users;
	
	@ApiOperation(value = "Returns all approved users only.", response = List.class)
	@GetMapping( value = "/users/approved", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getApprovedUsers() {
		return users.stream().filter(u-> u.isApproved() == true).collect(Collectors.toList());
	}

	@ApiOperation(value = "Returns all users.", response = List.class)
	@GetMapping( value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getSignedupUsers() {
		return users;
	}

	@ApiOperation(value = "Returns total number of users.", response = String.class)
	@GetMapping( value = "/users/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTotalUsers() {
		JsonObject data = Json.createObjectBuilder().add("count", users.stream().count()).build();
		
		return data.toString();
	}

	@ApiOperation(value = "Returns users with matched username.", response = List.class)
	@GetMapping( value = "/users/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getSignedupUser(@ApiParam(value = "Login username", required = true, type = "string value") 
	         @PathVariable String username) {
		return users.stream().filter(u -> u.getUsername().contains(username)).collect(Collectors.toList());
	}

	@ApiOperation(value = "Add new user.", response = String.class, consumes = "Profile data")
	@PostMapping( value = "/user/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewSignup(@RequestBody Profile profile) {
		users.add(profile);
		return ResponseEntity.ok("added profile");
	}

	@ApiOperation(value = "Add new user.", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful data entry!" ,response = String.class),
			@ApiResponse(code = 500, message = "Form data invalid!"),
			@ApiResponse(code = 404, message = "URL invalid!"),
			@ApiResponse(code = 403, message = "Request handler problem!")}
			)
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

	@ApiOperation(value = "Update a user account.", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated profile!" ,response = String.class),
			@ApiResponse(code = 500, message = "Update transaction invalid!"),
			@ApiResponse(code = 404, message = "URL invalid!"),
			@ApiResponse(code = 403, message = "Request handler problem!")}
			)
	@PutMapping( value = "/user/update/full/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateSignup(@RequestBody Profile profile, @PathVariable String username) {

		Optional.of(profile).ifPresent(prf -> { 
			users.removeIf( p -> p.getUsername().equals(username));
			users.add(profile);
		});
		return ResponseEntity.ok("updated profile");
	}

	@ApiOperation(value = "Update some profile detail.", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated profile!" ,response = String.class),
			@ApiResponse(code = 500, message = "Partial update transaction invalid!"),
			@ApiResponse(code = 404, message = "URL invalid!"),
			@ApiResponse(code = 403, message = "Request handler problem!")}
			)
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

	@ApiOperation(value = "Delete user account.", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted profile!" ,response = String.class),
			@ApiResponse(code = 500, message = "Delete transaction invalid!"),
			@ApiResponse(code = 404, message = "URL invalid!"),
			@ApiResponse(code = 403, message = "Request handler problem!")}
			)
	@DeleteMapping( value = "/user/delete/{username}")
	public ResponseEntity<?> deleteSignup(@PathVariable String username) {
		users.removeIf( p -> p.getUsername().equals(username));
		return ResponseEntity.ok("updated profile");
	}
	

}
