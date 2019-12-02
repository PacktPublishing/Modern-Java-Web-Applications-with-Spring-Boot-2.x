package org.packt.springboot22.vid04.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class InformClientFilter extends GenericFilterBean{

	
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		log.info("Logs generic results!");
		
		chain.doFilter(request, response);
		// any response-related code here
	}

}
