package org.packt.springboot22.vid02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.packt.springboot22.vid02.config.FarmDataConfig;
import org.packt.springboot22.vid02.model.data.Profile;
import org.packt.springboot22.vid02.repository.UserRepository;
import org.packt.springboot22.vid02.service.impl.SignupServiceImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = { FarmUpApplication.class, FarmDataConfig.class })
public class SignupServiceMockTest {
	
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private SignupServiceImpl signupService;

	
	private List<Profile> createTestData() {
		List<Profile> dbUser = new ArrayList<>();
		Profile p1 = new Profile();
		p1.setName("Anna Bern");
		p1.setMobile("639399992233");
		p1.setAddress("France");
		p1.setEmail("abern@gmail.com");
		p1.setApproved(false);
		p1.setUsername("abern");
		p1.setPassword("bernie@2");
		p1.setBday(Calendar.getInstance());

		Profile p2 = new Profile();
		p2.setName("Julia Robbie");
		p2.setMobile("639398881111");
		p2.setAddress("Peru");
		p2.setEmail("jrob@gmail.com");
		p2.setApproved(true);
		p2.setUsername("jrobbie");
		p2.setPassword("jrobbie@8");
		p2.setBday(Calendar.getInstance());

		dbUser.add(p1);
		dbUser.add(p2);

		return dbUser;
	}

	@DisplayName("Testing the request handler with BDDMockito.")
	@Test
	public void testGetSignedupUsers() throws Exception {
		BDDMockito.given(userRepository.getUsers()).willReturn(createTestData());
		List<Profile> testResult = signupService.getSignedupUsers();
		assertEquals(testResult.get(0).getUsername(),createTestData().get(0).getUsername());
		
		BDDMockito.then(userRepository).should(times(2)).getUsers();

	}
	
	@DisplayName("Testing the request handler with Mockito.")
	@Test
	public void testGetSignedupUsersMock() throws Exception{
		Mockito.lenient().when(userRepository.getUsers()).thenReturn(createTestData());
		List<Profile> testResult = signupService.getSignedupUsers();
		assertEquals(createTestData().get(0).getName(), testResult.get(0).getName());
		Mockito.verify(userRepository, times(1)).getUsers();
		
	}
	
	
}
