package org.packt.springboot22.vid02.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;

import org.packt.springboot22.vid02.model.data.Profile;
import org.packt.springboot22.vid02.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


public class SignupServiceImpl implements SignupService {

	@Autowired
	private List<Profile> users;
	
	
	@Override
	public List<Profile> getApprovedUsers() {
		return users.stream().filter(u-> u.isApproved() == true).collect(Collectors.toList());
	}
	
	@Override
	public List<Profile> getDisApprovedUsers() {
		return users.stream().filter(u-> u.isApproved() == false).collect(Collectors.toList());
	}

	@Override
	public List<Profile> getSignedupUsers() {
		return users;
	}

	@Override
	public Map<String,Object> getTotalUsers() {
		Map<String,Object> data = new HashMap<>();
		data.put("count", users.stream().count());
		return data;
	}

	@Override
	public List<Profile> getSignedupUser(String username) {
		return users.stream().filter(u -> u.getUsername().contains(username)).collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<?> addNewSignup(Profile profile) {
		users.add(profile);
		return ResponseEntity.ok("added profile");
	}

	@Override
	public ResponseEntity<?> addNewFormSignup(MultivaluedMap<String, String> reqParams) {
		Profile profile = new Profile();
		profile.setName(reqParams.getFirst("name"));
		profile.setEmail(reqParams.getFirst("email"));
		profile.setAddress(reqParams.getFirst("address"));
		profile.setMobile(reqParams.getFirst("mobile"));
		profile.setUsername(reqParams.getFirst("username"));
		profile.setPassword(reqParams.getFirst("password"));
		profile.setApproved(Boolean.parseBoolean(reqParams.getFirst("approved")));
		return ResponseEntity.ok("added profile");
	}

	@Override
	public ResponseEntity<?> updateSignup(Profile profile) {

		Optional.of(profile).ifPresent(prf -> { 
			users.removeIf( p -> p.getUsername().equals(prf.getUsername()));
			users.add(profile);
		});
		return ResponseEntity.ok("updated profile");
	}

	@Override
	public ResponseEntity<?> partialupdateSignup(Map<String, Object> updates, @PathParam("username") String username) {
	
		Profile profile = users.stream().filter(u -> u.getUsername().equals(username)).findAny().orElse(null);
		Optional.of(updates.get("username")).ifPresent( u -> {
			String user = (String) u;
			profile.setUsername(user);
		});
		Optional.of(updates.get("password")).ifPresent( p -> {
			String pass = (String) p;
			profile.setPassword(pass);
		});
		Optional.of(updates.get("name")).ifPresent( n -> {
			String name = (String) n;
			profile.setName(name);
		});
		Optional.of(updates.get("mobile")).ifPresent( m -> {
			String mobile = (String) m;
			profile.setMobile(mobile);
		});
		Optional.of(updates.get("email")).ifPresent( e -> {
			String email = (String) e;
			profile.setEmail(email);
		});
		Optional.of(updates.get("address")).ifPresent( a -> {
			String address = (String) a;
			profile.setAddress(address);
		});
		Optional.of(updates.get("approved")).ifPresent( a -> {
			boolean approved = (Boolean) a;
			profile.setApproved(approved);
		});
	
		return ResponseEntity.ok("updated profile");
	}

	@Override
	public ResponseEntity<?> deleteSignup(String username) {
		users.removeIf( p -> p.getUsername().equals(username));
		return ResponseEntity.ok("deleted profile");
	}

	
	
	


}
