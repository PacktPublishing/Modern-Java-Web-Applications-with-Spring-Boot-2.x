package org.packt.springboot22.vid04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableResourceServer
@SpringBootApplication
public class FarmUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmUpApplication.class, args);
	}

}
