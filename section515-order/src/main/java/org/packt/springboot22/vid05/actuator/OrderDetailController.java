package org.packt.springboot22.vid05.actuator;

import org.packt.springboot22.vid05.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Component
@RestControllerEndpoint(id = "order-endpoint")
@Log4j2
public class OrderDetailController {
	
	@Autowired
	private BasketRepository basketRepository;
	
	@PostMapping("/orderlog")
	public String logOrderDetail(@RequestParam("adminName") String adminName) {
		long numRec = basketRepository.count();
		log.info("Basket records: " + numRec);
		return "{ \"loggedBy\" : " + adminName +"}";
	}

}
