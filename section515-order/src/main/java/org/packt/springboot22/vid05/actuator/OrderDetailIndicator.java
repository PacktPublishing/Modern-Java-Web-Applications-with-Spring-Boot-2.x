package org.packt.springboot22.vid05.actuator;

import org.packt.springboot22.vid05.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Component
@Endpoint(id = "orderinfo", enableByDefault = true)
@Log4j2
public class OrderDetailIndicator {
	
	@Autowired
	private BasketRepository basketRepository;
	
	@ReadOperation
	public OrderInfo viewOrderInfo() {
		long numRec = basketRepository.count();
		return new OrderInfo("basket", numRec, ((numRec > 0) ? "active" : "inactive") );
	}
	
	@WriteOperation
	public OrderInfo logOrderInfo(@RequestParam("adminName") String adminName) {
		long numRec = basketRepository.count();
		log.info("order microservice: current record size is " + numRec);
		return new OrderInfo("basket", numRec, ((numRec > 0) ? "active" : "inactive") );
	}
	
	

}
