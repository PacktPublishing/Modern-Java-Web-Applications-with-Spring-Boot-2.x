package org.packt.springboot22.vid02.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.packt.springboot22.vid02.model.data.Harvest;
import org.springframework.http.ResponseEntity;

@Path("/harvest")
public interface HarvestService {
	
	@Path("/products")
	@GET
	@Produces( value = MediaType.APPLICATION_JSON)
	public List<Harvest> getAllHarvest();
	
	@Path("/products/{id}")
	@GET
	@Produces( value = MediaType.APPLICATION_JSON)
	public List<Harvest> getHarvest(@PathParam("id") Integer id);
	
	@Path("/product/add")
	@Consumes( value = MediaType.APPLICATION_JSON)
	@POST
	public ResponseEntity<?> addHarvest(Harvest harvest);

}
