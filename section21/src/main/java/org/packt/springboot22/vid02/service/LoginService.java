package org.packt.springboot22.vid02.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.packt.springboot22.vid02.model.data.Profile;

@Path("/login")
public interface LoginService {
	
	@Path("/users")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public List<Profile> getLoginUsers();
	
	@Path("/users/{username}")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public Profile getLoginUser(@PathParam("username") String username);
	
	

}
