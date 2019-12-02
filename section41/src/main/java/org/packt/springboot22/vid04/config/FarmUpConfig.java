package org.packt.springboot22.vid04.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class FarmUpConfig extends WebSecurityConfigurerAdapter {  
	
	    
  @Override  
  public void configure(HttpSecurity http) throws Exception {  
      http  
         .authorizeRequests()  
         .anyRequest().authenticated()  
         .and()
      // .and() 
         // .httpBasic().
      //  and()
         .formLogin()
         .loginPage("/login.html")  
         .failureUrl("/login.html?error=true")
         .defaultSuccessUrl("/farm/profile", true)
         .permitAll()
        .and()
         .logout()
           .logoutSuccessUrl("/logout.html")
         .permitAll()
         .and()
         .csrf().disable();
  }  
    
  @Override  
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
      auth.inMemoryAuthentication()  
          .withUser("sjctrags")  
          .password("{noop}sjctrags") 
          .roles("USER");  
  }  
  
  @Override
  public void configure(WebSecurity web) {
	  web
	  	.ignoring()
	  	.antMatchers("/resources/**")
	  	.antMatchers("/css/**")
	  	.antMatchers("/js/**")
	  	.antMatchers("/image/**");
  }
  
    
}
