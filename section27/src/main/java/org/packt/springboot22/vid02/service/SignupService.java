package org.packt.springboot22.vid02.service;

import java.util.List;
import java.util.Map;

import javax.json.JsonObject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.packt.springboot22.vid02.model.data.Profile;
import org.springframework.http.ResponseEntity;


public interface SignupService {
	
	
	public List<Profile> getApprovedUsers();
	
	
	public List<Profile> getDisApprovedUsers();
	
	
	public List<Profile> getSignedupUsers();
	
	
	public List<Profile> getSignedupUser(@PathParam("username") String username);
	
	
	public JsonObject getTotalUsers();
	
	
	public ResponseEntity<?> addNewSignup(Profile profile);
	
	
	public Response addNewFormSignup(MultivaluedMap<String, String> reqParams);
	
	
	public Response updateSignup(Profile profile);
	
	
	public Response partialupdateSignup(Map<String, Object> updates, @PathParam("username") String username);
	
	
	public Response deleteSignup(@PathParam("username") String username);
	

}
