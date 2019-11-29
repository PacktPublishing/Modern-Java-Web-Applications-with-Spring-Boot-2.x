package org.packt.springboot22.vid01.config;

import java.util.Properties;

import org.packt.springboot22.vid01.exception.HarvestFormException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class FarmUpExceptionResolverConfig {
	
	@Bean
    public SimpleMappingExceptionResolver customMappingExceptionResolver() {
    	SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.setProperty(HarvestFormException.class.getName(), "mst_harvest_exception");
       
        r.setExceptionMappings(mappings);  
        
        r.addStatusCode("mst_harvest_exception", 500);
        
        r.setDefaultErrorView("mst_farm_generic_error");    
        r.setExceptionAttribute("ex");     
        return r;
    }

}
