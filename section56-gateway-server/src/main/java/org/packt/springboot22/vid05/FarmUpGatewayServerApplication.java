package org.packt.springboot22.vid05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FarmUpGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmUpGatewayServerApplication.class, args);
	}

}
