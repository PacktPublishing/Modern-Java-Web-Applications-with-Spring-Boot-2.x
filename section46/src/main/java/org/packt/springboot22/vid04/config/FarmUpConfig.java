package org.packt.springboot22.vid04.config;

import org.packt.springboot22.vid04.security.FarmUpAuthRequestFilter;
import org.packt.springboot22.vid04.security.ProfileUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FarmUpConfig extends WebSecurityConfigurerAdapter {  
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
   
	@Autowired
	private ProfileUserDetailService profileUserDetailService;
  
  	@Autowired
	private FarmUpAuthRequestFilter jwtRequestFilter;
  
  	@Autowired
	private FarmAppAuthEntryPoint jwtAuthenticationEntryPoint;
  
  	@Bean
  	public Argon2PasswordEncoder passwordEncoder() {
  		return new Argon2PasswordEncoder();
  	}

  
  	@Override
  	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(profileUserDetailService).passwordEncoder(passwordEncoder());
  	}
  
  	@Override  
  	public void configure(HttpSecurity http) throws Exception {  
	      http  
	         .authorizeRequests()
	         .antMatchers("/farm/**").hasAnyAuthority("ADMIN READ", "USER READ")
		 	 .antMatchers("/authenticate").permitAll()
	         .anyRequest().fullyAuthenticated() 
	         .and()
	         .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
	         .exceptionHandling()
	                  .authenticationEntryPoint(jwtAuthenticationEntryPoint)
	         .and()
	         .logout()
	             .logoutUrl("/logout")
	             .logoutSuccessHandler(logoutSuccessHandler())
	             .permitAll()
	         .and()
	         .sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			 .and()
	         .csrf().disable();
	 } 
  
  	private LogoutSuccessHandler  logoutSuccessHandler ()  { 
  		return  new  HttpStatusReturningLogoutSuccessHandler (); 
  	}
  
  	@Bean
  	public SessionRegistry sessionRegistry() {
  		return new SessionRegistryImpl();
  	}
  
  	@Bean
  	public HttpSessionEventPublisher httpSessionEventPublisher() {
  		return new HttpSessionEventPublisher();
  	}
  
  	@Bean
 	public CorsConfigurationSource corsConfigurationSource() {
  		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
  		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
  		return source;
  	}
   
  	@Override
  	public void configure(WebSecurity web){
	  web
	  	.ignoring()
	  	.antMatchers("/resources/**")
	  	.antMatchers("/css/**")
	  	.antMatchers("/js/**")
	  	.antMatchers("/image/**");
  	}
}


