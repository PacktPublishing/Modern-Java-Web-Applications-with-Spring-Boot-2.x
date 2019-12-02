package org.packt.springboot22.vid06.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProfileRouter {
	
	    @Bean
	    public RouterFunction<ServerResponse> profileRoutes(ProfileHandler profileHandler) {
	        return RouterFunctions
	            .route(RequestPredicates.GET("/farm/profile/list")
	                       .and(RequestPredicates.accept(MediaType.TEXT_HTML)),
	                                profileHandler::profileResource)
	            .andRoute(RequestPredicates.GET("/farm/profile/save"), profileHandler::saveProfileGet)
	            .andRoute(RequestPredicates.POST("/farm/profile/save"), profileHandler::saveProfilePost);
	    }

}
