package org.packt.springboot22.vid05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FarmUpEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmUpEurekaServerApplication.class, args);
	}

}
