package org.packt.springboot22.vid04.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.packt.springboot22.vid04.security.ProfileUserDetailService;
import org.packt.springboot22.vid04.security.filter.ConfirmAuthFilter;
import org.packt.springboot22.vid04.security.filter.InformClientFilter;
import org.packt.springboot22.vid04.security.filter.LogAuthFilter;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,
securedEnabled=true)
public class FarmUpConfig extends WebSecurityConfigurerAdapter {  

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
		
		@Bean
		public AuthenticationFailureHandler createFailureHandler() {
			return new CustomFailureHandler();
		}
		
		@Bean
		public AuthenticationSuccessHandler createSuccessHandler() {
			return new CustomSuccessHandler();
		}
		
		@Bean
		public LogoutSuccessHandler createLogoutHandler() {
			return new CustomLogoutHandler();
		}
		
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
		public void configure(HttpSecurity http) throws Exception {  
			http  
			.authorizeRequests()
			.antMatchers("/login.html**").permitAll()
			.antMatchers("/access_denied.html", "/session_invalid.html", "/session_expired.html").permitAll()
			.antMatchers("/farm/**").hasAuthority("ADMIN READ")
			.anyRequest().authenticated() 
			.and()
			.formLogin()
				.loginPage("/login.html")  
				.successHandler(createSuccessHandler())
				.failureHandler(createFailureHandler() )
			.permitAll()
			.and()
		    .addFilter(new ConfirmAuthFilter())
			.addFilterBefore(new LogAuthFilter(), UsernamePasswordAuthenticationFilter.class)
			.addFilterAfter(new InformClientFilter(), ConcurrentSessionFilter.class)
			.logout()
				//.logoutSuccessUrl("/logout.html") 
				.logoutSuccessHandler(createLogoutHandler())
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
			.permitAll()
			.and()
        		.exceptionHandling()
        		.accessDeniedPage("/access_denied.html")
        	.and()
        	.rememberMe()
				.key("myPacktKey")		
				.rememberMeCookieName("remember-me")
				.tokenValiditySeconds(6400)
			.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				.sessionFixation().newSession()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.sessionRegistry(sessionRegistry())
			.and()
			.enableSessionUrlRewriting(false)
			.invalidSessionUrl("/session_invalid.html")
		  .and()
          .csrf().disable();
		}  
  
		@Bean
		public SessionRegistry sessionRegistry() {
			return new SessionRegistryImpl();
		}
  
		@Bean
		public HttpSessionEventPublisher httpSessionEventPublisher() {
			return new HttpSessionEventPublisher();
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

class CustomSuccessHandler implements AuthenticationSuccessHandler{
	private RedirectStrategy redirectStrategy =
			new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		redirectStrategy.sendRedirect(request, response,"/farm/profile");
		
	}
}

class CustomLogoutHandler implements LogoutSuccessHandler{
	private RedirectStrategy redirectStrategy =	new DefaultRedirectStrategy();
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		redirectStrategy.sendRedirect(request, response,"/logout.html");
		
	}
	
}
	
class CustomFailureHandler implements AuthenticationFailureHandler{
	
	private RedirectStrategy redirectStrategy =
			new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException exception) throws IOException, ServletException {
			if(exception.getClass().equals(SessionAuthenticationException.class)) {
				redirectStrategy.sendRedirect(request, response, "/login.html?error=expired");
			}else {
				redirectStrategy.sendRedirect(request, response, "/login.html?error=credential");
			}
		
	}
	
}
