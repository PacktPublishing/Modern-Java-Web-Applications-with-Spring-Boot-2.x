package org.ceva.products;

import java.util.ArrayList;
import java.util.List;

import org.ceva.products.model.OrderProduct;
import org.ceva.products.model.PaymentProduct;
import org.ceva.products.model.Product;
import org.ceva.products.repository.OrderRepository;
import org.ceva.products.repository.PaymentRepository;
import org.ceva.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OrderPaymentRepoTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	

	@Test
	public void addProductTest() {
		
		Product prod = new Product();
		prod.setId(101L);
		prod.setName("Fan");
		prod.setPrice(2000.00F);
		prod.setStock(500);
		
		productRepository.save(prod);
		productRepository.findAll().stream().forEach((p)->{
			System.out.printf("%d %-30s %-20f %-20d \n", 
					p.getId(), p.getName(), p.getPrice(), p.getStock());
			
		});
		
	}
	
	@Test
	public void addOrderPaymentDelivery() {
		System.out.println("----------Product Population------------");
		
		Product prod1 = new Product();
		prod1.setId(101L);
		prod1.setName("Fan");
		prod1.setPrice(2000.00F);
		prod1.setStock(500);
		
		Product prod2 = new Product();
		prod2.setId(102L);
		prod2.setName("Rice Cooker");
		prod2.setPrice(10500.00F);
		prod2.setStock(10);
		
		Product prod3 = new Product();
		prod3.setId(103L);
		prod3.setName("Frying Pan");
		prod3.setPrice(300.00F);
		prod3.setStock(1000);
		
		List<Product> prods = new ArrayList<>();
		prods.add(prod1);
		prods.add(prod2);
		prods.add(prod3);
		
		productRepository.saveAll(prods);
		productRepository.findAll().stream().forEach((p)->{
			System.out.printf("%d %-30s %-20f %-20d \n", 
					p.getId(), p.getName(), p.getPrice(), p.getStock());
			
		});
		
		System.out.println("----------Order Stage------------");
		
		OrderProduct order1 = new OrderProduct();
		order1.setId(201L);
		order1.setPid(103L);
		order1.setQty(10);
		order1.setAmount(20000.00);
		order1.setOrderId(1000L);
		order1.setStatus("created");
		
		orderRepository.save(order1);
		orderRepository.findAll().stream().forEach((o)->{
			System.out.printf("%d %-30d %-30d %-30f %-30s\n", 
					o.getId(),  o.getPid(), o.getQty(), o.getAmount(), o.getStatus());
			
    	});
		
		orderRepository.updateStatusByOrderId("cancelled", 1000L);
		orderRepository.findAll().stream().forEach((o)->{
			System.out.printf("%d %-30d %-30d %-30f %-30s\n", 
					o.getId(),  o.getPid(), o.getQty(), o.getAmount(), o.getStatus());
			
    	});
		
		System.out.println("----------Payment Stage------------");
		
		PaymentProduct payment = new PaymentProduct();
		payment.setId(501L);
		payment.setOrderId(1000L);
		payment.setTotalAmount(50000.00);
		payment.setTotalDue(20000.00);
		
		paymentRepository.save(payment);
		orderRepository.updateStatusByOrderId("confirmed", payment.getOrderId());
		paymentRepository.findAll().stream().forEach((pay)->{
			System.out.printf("%d %-30d %-30f %-30f \n", 
					pay.getId(),  pay.getOrderId(), pay.getTotalAmount(), pay.getTotalDue());
			
    	});
		
		System.out.println("----------Delivery Stage------------");
		orderRepository.findByOrderIdAndStatus(1001L, "confirmed").stream().forEach((o)->{
			System.out.printf("%d %-30d %-30d %-30f %-30s\n", 
					o.getId(),  o.getPid(), o.getQty(), o.getAmount(), o.getStatus());
			
    	});
		
	}

}
