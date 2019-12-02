package org.packt.springboot22.vid06.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Configuration
public class FarmUpClientConfig {
	
	private static final String BASE_URL = "http://localhost:8088";
	 
    @Bean
    public WebClient webClient() {
 
    	TcpClient tcpClient = TcpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(2))
                                .addHandlerLast(new WriteTimeoutHandler(2)));
 
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .defaultCookie("packt", "springboot22", "spring52", "webflux")
                .defaultCookie("secretToken", UUID.randomUUID().toString())
                .defaultHeader(HttpHeaders.USER_AGENT, "Spring Boot 2.2")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


}
