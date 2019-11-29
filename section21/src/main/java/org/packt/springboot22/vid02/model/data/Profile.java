package org.packt.springboot22.vid02.model.data;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class Profile {
	
	private String name;
	private String mobile;
	private String address;
	private String email;
	private String username;
	private String password;
	private boolean approved;
	private Calendar bday;

}
