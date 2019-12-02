package org.packt.springboot22.vid04.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.packt.springboot22.vid04.repository.LoginRepository;
import org.packt.springboot22.vid04.repository.PermissionRepository;
import org.packt.springboot22.vid04.repository.PermissionSetsRepository;
import org.packt.springboot22.vid04.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class ConfirmAuthFilter extends UsernamePasswordAuthenticationFilter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private PermissionSetsRepository permissionSetsRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String username = authResult.getName();
        String password = authResult.getCredentials().toString();
        
      
                 
		UsernamePasswordAuthenticationToken userDetails = 
				 new UsernamePasswordAuthenticationToken(username, password);
		
		setDetails(request, userDetails);	
		chain.doFilter(request, response);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.sendRedirect("/login.html?error=credential");
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		 String username = request.getParameter("username");
	     String password = request.getParameter("password");
	     
	     UsernamePasswordAuthenticationToken authenticationToken = 
	    		 new UsernamePasswordAuthenticationToken(username, password);

	        return authenticationManager.authenticate(authenticationToken);
	}
	
}
