package org.packt.springboot22.vid01.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class LoginAttemptEventListener implements ApplicationListener<LoginAttemptEvent> {

	@Override
	public void onApplicationEvent(LoginAttemptEvent event) {
		log.info("login attempt from user:" + event.getUsername() 
		               + " with pwd:" + event.getPassword());

	}

}
