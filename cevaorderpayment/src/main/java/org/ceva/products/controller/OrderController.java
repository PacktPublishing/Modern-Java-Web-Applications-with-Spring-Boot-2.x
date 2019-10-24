package org.ceva.products.controller;

import java.util.List;

import org.ceva.products.model.OrderProduct;
import org.ceva.products.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ceva")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping( value = "/order/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addProduct(@RequestBody OrderProduct order) {
		orderRepository.save(order);
		return ResponseEntity.ok("created");
	}
	
	@GetMapping( value = "/order/delivery/{order_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deliverProduct(@PathVariable("order_id") Long orderId) {
		List<OrderProduct> confirmedOrders = orderRepository.findByOrderIdAndStatus(orderId, "confirmed");
		if(confirmedOrders.size() == 0) {
			return ResponseEntity.ok("cancelled");
		}
		orderRepository.updateStatusByOrderId("delivered", orderId);
		return ResponseEntity.ok("delivered");
	} 

}
