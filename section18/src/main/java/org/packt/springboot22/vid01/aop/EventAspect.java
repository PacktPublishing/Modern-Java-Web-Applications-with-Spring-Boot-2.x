package org.packt.springboot22.vid01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.packt.springboot22.vid01.event.LoginAttemptEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
@Order(2)
public class EventAspect {
	
	@Autowired
	private ApplicationEventPublisher farmEventPublisher;

	
	@Pointcut("execution(public * org.packt.springboot22.vid01.controller.LoginFormController.loginUser(..))")
	public void loginControllerPointcut() { }

	@Before("loginControllerPointcut() && args(atts, username, password)")
	public void authenticate(JoinPoint pjp, RedirectAttributes atts, 
	    String username, String password) {
		
		log.info(username);
		farmEventPublisher.publishEvent(new LoginAttemptEvent(this, username, password));
		
	
		
	}
}
