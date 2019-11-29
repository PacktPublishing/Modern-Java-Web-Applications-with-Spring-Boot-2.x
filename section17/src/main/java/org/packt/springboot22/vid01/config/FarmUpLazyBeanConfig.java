package org.packt.springboot22.vid01.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class FarmUpLazyBeanConfig {
	
	@Bean
	public LocalDate localDate() {
		return LocalDate.now();
	}
	
	@Bean
	public String webmaster() {
		return "sherwin.tragura@alibataweb.com";
	}

}
