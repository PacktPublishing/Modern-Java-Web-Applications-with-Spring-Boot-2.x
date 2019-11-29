package org.packt.springboot22.vid03.service;

import org.packt.springboot22.vid03.model.Location;
import org.packt.springboot22.vid03.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	public Iterable<Location> getAllMarketLoc(){
		return locationRepository.findAll();
	}
	
	public void addMarketLoc(Location loc) {
		locationRepository.save(loc);
	}
	
	public void updateMarketLoc(Location loc) {
		locationRepository.save(loc);
	}
	
	public void deleteMarketLoc(Long id) {
		locationRepository.deleteById(id);
	}
	
	
	
	

}
