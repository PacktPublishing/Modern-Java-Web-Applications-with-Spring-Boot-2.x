package org.packt.springboot22.vid06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProfileRouter {
	
	@Autowired
	private ProfileHandler profileHandler;
	
	@Bean
    public RouterFunction<ServerResponse> profileRoutes(ProfileHandler profileHandler) {
        return RouterFunctions
            .route(RequestPredicates.GET("/farm/profile/list"), profileHandler::getUsers)
            .andRoute(RequestPredicates.POST("/farm/profile/save")
            		.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), profileHandler::saveProfile);
	}

}
