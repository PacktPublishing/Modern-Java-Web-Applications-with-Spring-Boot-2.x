package org.packt.springboot22.vid05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class FarmUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmUpApplication.class, args);
	}

}
