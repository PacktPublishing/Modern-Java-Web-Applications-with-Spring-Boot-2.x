package org.packt.springboot22.vid01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
@Order(0)
public class LogAspect {
	
		@Pointcut("within(org.packt.springboot22.vid01.controller..*)")
	    public void applicationPackagePointcut() { }
		
		@After("applicationPackagePointcut()")
		public void logController(JoinPoint joinPoint) {
		     log.info("accessed the controller: " + joinPoint.getTarget());	
		}
		
}
