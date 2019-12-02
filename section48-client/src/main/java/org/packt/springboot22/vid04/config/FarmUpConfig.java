package org.packt.springboot22.vid04.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

public class FarmUpConfig extends WebSecurityConfigurerAdapter{

	 @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            .antMatchers("/login**").permitAll()
	            .anyRequest().authenticated()
	            .and()
	            .oauth2Login()
	            .and()
	            .logout()
	            .logoutSuccessUrl("http://localhost:8081/auth/logout.html")
	            .deleteCookies("JSESSIONID")
	            .permitAll();
	            
	    }
}
