package org.ceva.products.controller;

import java.util.List;

import org.ceva.products.model.Product;
import org.ceva.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ceva")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping( value = "/product/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addProduct(@RequestBody Product prod) {
		productRepository.save(prod);
		return ResponseEntity.ok("created");
	}
	
	@GetMapping( value = "/product/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProductList() {
		return productRepository.findAll();
	}
	
}
