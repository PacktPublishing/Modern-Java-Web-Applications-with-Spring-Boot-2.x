package org.packt.springboot22.vid02;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.packt.springboot22.vid02.config.FarmDataConfig;
import org.packt.springboot22.vid02.model.data.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, 
                 classes = {FarmUpApplication.class, FarmDataConfig.class})
@TestPropertySource(
		  locations = "classpath:application.properties")
//@AutoConfigureMockMvc
public class SignupServiceSpringBootTest {
	
	//@Autowired
	//private MockMvc mockMvc;
	
	@Autowired
	private TestRestTemplate  restTemplate;
	
	@LocalServerPort
	private int port;

	 
	@Test
	public void testGetRestWS() throws Exception{
		String host = "http://localhost:" + port;
		List<Profile> response
		  = restTemplate.getForObject(host + "/farmservice/signup/users", List.class);
		System.out.println(response);
        
	}

}
