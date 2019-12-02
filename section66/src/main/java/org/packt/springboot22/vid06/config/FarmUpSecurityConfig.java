package org.packt.springboot22.vid06.config;

import java.net.URI;

import org.packt.springboot22.vid06.security.ProfileUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;



@EnableWebFluxSecurity
@EnableReactiveMethodSecurity(proxyTargetClass = true)
public class FarmUpSecurityConfig {
	
	 @Autowired
	 private ProfileUserDetailService profileUserDetailService;
	  
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
	 }

	
	  @Bean
	  public ReactiveAuthenticationManager authenticationManager() {
	        UserDetailsRepositoryReactiveAuthenticationManager authenticationManager =
	                new UserDetailsRepositoryReactiveAuthenticationManager(profileUserDetailService);
	        authenticationManager.setPasswordEncoder(passwordEncoder());
	        return authenticationManager;
	    }
	  
	  
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    		http.cors().disable() 
            	.authorizeExchange()
            	.pathMatchers("/login**", "/logout.html", "/img/**", "/css/**", "/js/**")
                .permitAll()
                .pathMatchers("/**").hasAuthority("ADMIN")
                .anyExchange()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login.html")
                    .authenticationSuccessHandler(
                    		new RedirectServerAuthenticationSuccessHandler("/farm/profile/list"))
                .and()
                .logout()
               	.logoutUrl("/logout")
                	.requiresLogout(
                			ServerWebExchangeMatchers.pathMatchers(HttpMethod.GET, "/logout"))
                	.logoutSuccessHandler(logoutSuccessHandler("/logout.html"))
                .and().csrf().disable();
                
        return http.build();
    }
    
    public ServerLogoutSuccessHandler logoutSuccessHandler(String uri) {
        RedirectServerLogoutSuccessHandler successHandler = 
        		             new RedirectServerLogoutSuccessHandler();
        successHandler.setLogoutSuccessUrl(URI.create(uri));
        return successHandler;
    }
    
    @Bean
    public ServerSecurityContextRepository securityContextRepository() {
        WebSessionServerSecurityContextRepository securityContextRepository =
                new WebSessionServerSecurityContextRepository();
        securityContextRepository.setSpringSecurityContextAttrName("packt-security-context");
        return securityContextRepository;
    }


}
