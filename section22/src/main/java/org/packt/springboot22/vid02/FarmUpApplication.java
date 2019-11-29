package org.packt.springboot22.vid02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class FarmUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmUpApplication.class, args);
	}

}
