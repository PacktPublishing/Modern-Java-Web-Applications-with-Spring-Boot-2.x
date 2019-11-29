package org.packt.springboot22.vid01.event;

import org.springframework.context.ApplicationEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginAttemptEvent extends ApplicationEvent {

	private String username;
	private String password;

	public LoginAttemptEvent(Object source, String username, String password) {
		super(source);
		this.username = username;
		this.password = password;
	}

}
