package org.packt.springboot22.vid04.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
@Order(2)
public class FarmUpOAuth2Config extends AuthorizationServerConfigurerAdapter{
	
	@Value("${oauth.clientAId}")
    private String clientID;
	
    @Value("${oauth.clientASecret}")
    private String clientSecret;
    
    @Value("${oauth.redirectUris}")
    private String redirectURLs;
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {  }
          
    @Override
    public void configure(
        AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()") // /oauth/token_key
            .checkTokenAccess("isAuthenticated()"); // /oauth/check_token
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient(clientID)
            .secret(passwordEncoder.encode(clientSecret))
            .authorizedGrantTypes("authorization_code")
            .scopes("trust")
            .autoApprove(true)
            .redirectUris(redirectURLs);
    	
    }
}
