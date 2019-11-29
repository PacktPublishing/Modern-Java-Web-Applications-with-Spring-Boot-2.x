package org.packt.springboot22.vid02.service;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.packt.springboot22.vid02.model.data.Profile;
import org.springframework.http.ResponseEntity;

@Path("/signup")
public interface SignupService {
	
	@Path("/users/approved")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public List<Profile> getApprovedUsers();
	
	@Path("/users/notapproved")
	@Produces(value = MediaType.APPLICATION_XML)
	@GET
	public List<Profile> getDisApprovedUsers();
	
	@Path("/users")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public List<Profile> getSignedupUsers();
	
	@Path("/users/{username}")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public List<Profile> getSignedupUser(@PathParam("username") String username);
	
	@Path("/users/count")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public Map<String,Object> getTotalUsers();
	
	@Path("/user/add")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@POST
	public ResponseEntity<?> addNewSignup(Profile profile);
	
	@Path("/user/add/form")
	@Consumes(value = MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	public ResponseEntity<?> addNewFormSignup(MultivaluedMap<String, String> reqParams);
	
	@Path("/user/update")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@PUT
	public ResponseEntity<?> updateSignup(Profile profile);
	
	@Path("/user/update/{username}")
	@PATCH
	public ResponseEntity<?> partialupdateSignup(Map<String, Object> updates, @PathParam("username") String username);
	
	@Path("/user/delete/{username}")
	@DELETE
	@Produces(value = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> deleteSignup(@PathParam("username") String username);
	

}
