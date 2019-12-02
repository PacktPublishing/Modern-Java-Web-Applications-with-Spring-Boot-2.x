package org.packt.springboot22.vid04.config;

import org.packt.springboot22.vid04.security.ProfileUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@Configuration
@Order(1)
public class FarmUpConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	 private ProfileUserDetailService profileUserDetailService;
  
	 @Bean
	 public Argon2PasswordEncoder passwordEncoder() {
	    return new Argon2PasswordEncoder();
	 }

	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     auth.userDetailsService(profileUserDetailService).passwordEncoder(passwordEncoder());
	 }
	 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
            .antMatchers("/login**","/logout.html", "/oauth/authorize")
            .and()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll();
    }
    
   
    @Bean
  	@Override
  	public AuthenticationManager authenticationManagerBean() throws Exception {
  		return super.authenticationManagerBean();
  	}
}
