package org.packt.springboot22.vid06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class FarmUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmUpApplication.class, args);
	}

}
