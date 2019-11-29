package org.packt.springboot22.vid02.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;

import org.packt.springboot22.vid02.model.data.Profile;
import org.packt.springboot22.vid02.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Path("/signup")
public class SignupServiceImpl implements SignupService {

	@Autowired
	private List<Profile> users;
	
	@Context
    private Sse sse;
	
	@Path("/users/approved")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	@Override
	public List<Profile> getApprovedUsers() {
		return users.stream().filter(u-> u.isApproved() == true).collect(Collectors.toList());
	}
	
	@Path("/users/notapproved")
	@Produces(value = MediaType.APPLICATION_XML)
	@GET
	@Override
	public List<Profile> getDisApprovedUsers() {
		return users.stream().filter(u-> u.isApproved() == false).collect(Collectors.toList());
	}

	
	@Path("/users")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	@Override
	public List<Profile> getSignedupUsers() {
		return users;
	}
	
	@Path("/users/count")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	@Override
	public JsonObject getTotalUsers() {
		JsonObject data = Json.createObjectBuilder()
				.add("count", users.stream().count()).build();
		return data;
	}
	
	@GetMapping( value = "/users/login", produces = MediaType.APPLICATION_JSON)
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
	
	@GetMapping( value = "/users/countjson", produces = MediaType.APPLICATION_JSON)
	public String getJsonPTotal() {
		JsonObject jsonProd = Json.createObjectBuilder()
				.add("count", users.size())
				.build();
		return jsonProd.toString();
	}

	@Path("/users/{username}")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	@Override
	public List<Profile> getSignedupUser(String username) {
		return users.stream().filter(u -> u.getUsername().contains(username)).collect(Collectors.toList());
	}

	@Path("/user/add")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@POST
	@Override
	public ResponseEntity<?> addNewSignup(Profile profile) {
		users.add(profile);
		return ResponseEntity.ok("added profile");
	}

	@Path("/user/add/form")
	@Consumes(value = MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	@Override
	public Response addNewFormSignup(MultivaluedMap<String, String> reqParams) {
		Profile profile = new Profile();
		profile.setName(reqParams.getFirst("name"));
		profile.setEmail(reqParams.getFirst("email"));
		profile.setAddress(reqParams.getFirst("address"));
		profile.setMobile(reqParams.getFirst("mobile"));
		profile.setUsername(reqParams.getFirst("username"));
		profile.setPassword(reqParams.getFirst("password"));
		profile.setApproved(Boolean.parseBoolean(reqParams.getFirst("approved")));
		return Response.status(200).entity("added profile").build();
	}

	@Path("/user/update")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@PUT
	@Override
	public Response updateSignup(Profile profile) {

		Optional.of(profile).ifPresent(prf -> { 
			users.removeIf( p -> p.getUsername().equals(prf.getUsername()));
			users.add(profile);
		});
		return Response.status(200).entity("updated profile").build();
	}

	@Path("/user/update/{username}")
	@PATCH
	@Override
	public Response partialupdateSignup(Map<String, Object> updates, @PathParam("username") String username) {
	
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
	
		return Response.status(200).entity("updated profile").build();
	}

	@Path("/user/delete/{username}")
	@DELETE
	@Produces(value = MediaType.APPLICATION_JSON)
	@Override
	public Response deleteSignup(String username) {
		users.removeIf( p -> p.getUsername().equals(username));
		return Response.status(200).entity("deleted profile").build();
	}

	
	@GET
    @Path("/users/sse")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void sendIntEvents(@Context SseEventSink sseEventSink) {
    	CompletableFuture<Void> runStrEvent = 
    			CompletableFuture.runAsync(()->{
    				for(Profile prod : users) {
    	                try {
    	                    TimeUnit.SECONDS.sleep(5);
    	                    System.out.println("Sending profile info of: " + prod.getName());
    	                    OutboundSseEvent prodEvents = sse.newEventBuilder()
    	    		  				.name("user profile")
    	                            .mediaType(MediaType.APPLICATION_JSON_TYPE)
    	                            .data(Profile.class, prod)
    	                            .build();
    	                    sseEventSink.send(prodEvents);
    	                } catch (InterruptedException ex) {
    	                    ex.printStackTrace();
    	                }
    	            }
    	}); 
    	runStrEvent.whenComplete((resp, ex)->{
    		System.out.println("Done server messaging...");;
    	});
    	
    }
		
	@GetMapping( value = "/users/async", produces = MediaType.APPLICATION_JSON)
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
