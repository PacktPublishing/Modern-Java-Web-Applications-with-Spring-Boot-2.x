package org.packt.springboot22.vid02;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid02.client.SignupServiceClient;
import org.packt.springboot22.vid02.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;

@ExtendWith(SpringExtension.class)
@RestClientTest(SignupServiceClient.class)
@ContextConfiguration(classes = {FarmUpApplication.class})
public class SignupServiceRestClientTest {
	
	    @Autowired
	    private SignupServiceClient client;
	 
	    @Autowired
	    private MockRestServiceServer server;
	 	  
	    @BeforeEach
	    public void setUp() throws Exception {
	    	Profile p1 = new Profile();
			p1.setName("Anna Bern");
			p1.setMobile("639399992233");
			p1.setAddress("France");
			p1.setEmail("abern@gmail.com");
			p1.setApproved(false);
			p1.setUsername("abern");
			p1.setPassword("bernie@2");
			
			List<Profile> users = new ArrayList<>();
		        users.add(p1);
		         
			
	        Jsonb jsonb = JsonbBuilder.create();
	        String jsonData = jsonb.toJson(users);
	       
	        this.server.expect(requestTo("http://localhost:8082/farmservice/signup/users/abern"))
	           .andExpect(method(HttpMethod.GET))
	           .andRespond(withStatus(HttpStatus.OK)
	           .contentType(MediaType.APPLICATION_JSON)
	           .body(jsonData));
	    }
	    
	    @Test
	    public void testClientGetUserProfile() {
	    	String testResult = client.consumeGetUserProfile("abern");
	    	System.out.println(testResult);
	    }

}
