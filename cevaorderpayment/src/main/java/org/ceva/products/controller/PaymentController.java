package org.ceva.products.controller;

import org.ceva.products.model.PaymentProduct;
import org.ceva.products.repository.OrderRepository;
import org.ceva.products.repository.PaymentRepository;
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
public class PaymentController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@PostMapping( value = "/payment/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addProduct(@RequestBody PaymentProduct payment) {
		if(payment.getTotalAmount() >= payment.getTotalDue() &&
				payment.getTotalAmount() > 0) {
			orderRepository.updateStatusByOrderId("confirmed", payment.getOrderId());
			paymentRepository.save(payment);
			return ResponseEntity.ok("confirmed");
		}
		orderRepository.updateStatusByOrderId("cancelled", payment.getOrderId());
		return ResponseEntity.ok("declined");
	} 
	
	
	
	
	

}
