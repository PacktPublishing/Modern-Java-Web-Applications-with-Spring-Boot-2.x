package org.packt.springboot22.vid04.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
    @RequestMapping("/logout.html")
    public void exit(HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	 if (auth != null){    
             new SecurityContextLogoutHandler().logout(request, response, null);
          }
    	 SecurityContextHolder.getContext().setAuthentication(null);
    	try {
          response.sendRedirect("http://localhost:8082/farm/profile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
