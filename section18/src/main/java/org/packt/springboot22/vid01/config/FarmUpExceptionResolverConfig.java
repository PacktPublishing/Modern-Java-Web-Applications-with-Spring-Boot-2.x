package org.packt.springboot22.vid01.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class FarmUpExceptionResolverConfig {
	
	@Bean
    public SimpleMappingExceptionResolver customMappingExceptionResolver() {
    	SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
       //  mappings.setProperty(AuthenticationException.class.getName(), "mst_authentication_error");
       
        r.setExceptionMappings(mappings);  
        
        r.addStatusCode("mst_authentication_error", 500);
        r.setDefaultErrorView("mst_farm_generic_error");    
        r.setExceptionAttribute("ex");     
        return r;
    }

}
