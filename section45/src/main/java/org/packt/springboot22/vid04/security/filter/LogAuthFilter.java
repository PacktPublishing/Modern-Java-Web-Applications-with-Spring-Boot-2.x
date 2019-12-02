package org.packt.springboot22.vid04.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogAuthFilter extends OncePerRequestFilter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.setAttribute("username", username);
	    request.setAttribute("password", password);
	    
		log.info("User " + username +" has logged in!");
		filterChain.doFilter(request, response);
		// any response-related code here
	}

	
	

}
