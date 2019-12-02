package org.packt.springboot22.vid04.config;

import org.packt.springboot22.vid04.security.ProfileUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FarmUpConfig extends WebSecurityConfigurerAdapter {  
   
  @Autowired
  private ProfileUserDetailService profileUserDetailService;
  
  @Bean
  public Argon2PasswordEncoder passwordEncoder() {
    return new Argon2PasswordEncoder();
  };

  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(profileUserDetailService).passwordEncoder(passwordEncoder());
  }
  
  @Override  
  public void configure(HttpSecurity http) throws Exception {  
      http  
         .authorizeRequests()
         .antMatchers("/farm/**").hasAnyAuthority("ADMIN READ", "USER READ")
         .anyRequest().fullyAuthenticated() 
         .and()
      // .httpBasic()
      // .and()
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
         .exceptionHandling()
             .accessDeniedPage("/access_denied.html")
         .and()
         .csrf().disable();
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

