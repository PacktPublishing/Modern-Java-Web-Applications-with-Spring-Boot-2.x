package org.packt.springboot22.vid01.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
@Order(1)
public class LoginAuthAspect {
	
	
	@Pointcut("execution(public * org.packt.springboot22.vid01.controller.LoginFormController.loginUser(..))")
	public void loginControllerPointcut() { }

	@Around("loginControllerPointcut() && args(atts, username, password)")
	public String authenticate(ProceedingJoinPoint pjp, RedirectAttributes atts, String username, String password) {
		
		List<String> validUsers = Arrays.asList("admin@gmail.com", "user@yahoo.com");
		Object args[] = pjp.getArgs();
		final String user = (String) args[1];
	
		if(validUsers.stream().filter(u -> u.equals(user.trim())).findAny().orElse(null) != null) {
			String view = null;
			try {
				log.info("confirmed logged in is user:" + user);
				view = (String) pjp.proceed();
			} catch (Throwable e) {
				log.info("user:" + user + " is invalid!");
				view = "mst_authentication_error";
			}
			return view;
		}
	    return	"mst_authentication_error";
		
	
		
	}

}
