package org.packt.springboot22.vid02.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class FarmAppJerseyConfig extends ResourceConfig{

	public FarmAppJerseyConfig() {
		packages("org.packt.springboot22.vid02");
	}
	
}
