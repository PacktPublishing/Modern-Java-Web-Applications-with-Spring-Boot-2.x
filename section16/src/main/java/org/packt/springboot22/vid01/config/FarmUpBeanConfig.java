package org.packt.springboot22.vid01.config;

import java.util.ArrayList;
import java.util.List;

import org.packt.springboot22.vid01.model.HarvestForm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class FarmUpBeanConfig {
	
	@Bean
	public String projectName() {
		return "FarmUp Harvester";
	}
	
	@Lazy
	@Bean
	public String tabName() {
		return "FarmUp";
	}
	
	@Bean
	public List<HarvestForm> dbHarvest(){
		return new ArrayList<>();
	}

}
