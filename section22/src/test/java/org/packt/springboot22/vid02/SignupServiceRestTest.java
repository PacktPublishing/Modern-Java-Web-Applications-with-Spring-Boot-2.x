package org.packt.springboot22.vid02;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;
import org.packt.springboot22.vid02.config.FarmDataConfig;
import org.packt.springboot22.vid02.model.Profile;
import org.packt.springboot22.vid02.service.SignupController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ContextConfiguration(classes = {FarmDataConfig.class, SignupController.class})
@WebMvcTest
public class SignupServiceRestTest {
	
	@Autowired
	private MockMvc mockMvc;
	 
	@Test
	public void testGetService() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/signup/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse resultDOW = result.getResponse();
        assertNotNull(resultDOW);
        
	}
	
	@Test
	public void testGetPathVarService() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				                         .get("/signup/users/{username}","sjctrags")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andReturn();

        MockHttpServletResponse resultDOW = result.getResponse();
        System.out.println(resultDOW);
	}
	
		
	@Test
	public void testPostService() throws Exception{
		Profile profile = new Profile();
		profile.setName("John Coala");
		profile.setAddress("Manila");
		profile.setMobile("1111111");
		profile.setEmail("jcoala@yahoo.com");
		profile.setApproved(true);
		profile.setUsername("jcoala");
		profile.setPassword("jcoala@@&$");
				
		Jsonb jsonb = JsonbBuilder.create();
		String profileStr = jsonb.toJson(profile);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/signup/user/add")
                .content(profileStr)
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse resultDOW = result.getResponse();
        assertNotNull(resultDOW);
	}
	
	@Test
	public void testPostFormService() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/signup/user/add/form")
                .param("name", "John")
                .param("mobile", "09898989")
                .param("email", "jwick@gmail.com")
                .param("address", "Manila")
                .param("username", "jwick")
                .param("password", "jwick@@22")
                .param("approved", "true")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse resultDOW = result.getResponse();
        assertNotNull(resultDOW);
	}

}
