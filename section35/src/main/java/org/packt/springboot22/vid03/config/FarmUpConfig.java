package org.packt.springboot22.vid03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;

@Configuration
public class FarmUpConfig implements RepositoryRestConfigurer{
	
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
        config.useHalAsDefaultJsonMediaType(false);
    }
    

}
