package org.packt.springboot22.vid01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class FarmUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmUpApplication.class, args);
	}

}
