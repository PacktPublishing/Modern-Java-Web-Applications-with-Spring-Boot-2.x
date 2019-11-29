package org.packt.springboot22.vid03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.packt.springboot22.vid03.model.Profile;
import org.packt.springboot22.vid03.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@MybatisTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SignupServiceMockTest {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	
	@Test
	public void testAddProfile() {
		Profile p = new Profile();
		p.setId(300L);
		p.setName("Jean Grey");
		p.setAddress("Makati");
		p.setEmail("jgrey@gmail.com");
		p.setMobile("45945894");
		p.setUsername("jeangrey3");
		p.setPassword("grey");
		p.setApproved(true);
		p.setBday(LocalDate.now());
		System.out.println(p.getId());
		
		profileRepository.save(p);
		System.out.println(profileRepository.findAll());
		System.out.println(profileRepository.findByNameLike("%Grey%"));
		System.out.println(profileRepository.findProfile(300L));
		
	}
	
	@Test
	public void testGetStreamProfiles() {
		Profile p = new Profile();
		p.setId(300L);
		p.setName("Jean Grey");
		p.setAddress("Makati");
		p.setEmail("jgrey@gmail.com");
		p.setMobile("45945894");
		p.setUsername("jeangrey3");
		p.setPassword("grey");
		p.setApproved(true);
		p.setBday(LocalDate.now());
		System.out.println(p.getId());
		
		profileRepository.save(p);
		p.setEmail("gggg@gmail.com");
		profileRepository.update(p);
		System.out.println(profileRepository.findAll());
		profileRepository.delete(300L);
		System.out.println(profileRepository.findAll());
	}
	
	@Test
	public void testAddManyProfile() {
		
		Profile p1 = new Profile();
		p1.setId(400L);
		p1.setName("Gina Gomez");
		p1.setAddress("London");
		p1.setEmail("ging@gmail.com");
		p1.setMobile("45945894");
		p1.setUsername("ging");
		p1.setPassword("ging@37");
		p1.setApproved(true);
		p1.setBday(LocalDate.now());
		
		Profile p2 = new Profile();
		p2.setId(600L);
		p2.setName("Mark Gomez");
		p2.setAddress("California");
		p2.setEmail("markgom@gmail.com");
		p2.setMobile("232323232");
		p2.setUsername("markg");
		p2.setPassword("mg0937$%");
		p2.setApproved(false);
		p2.setBday(LocalDate.now());
		
			
		List<Profile> records = new ArrayList<>();
		records.add(p1);
		records.add(p2);
		profileRepository.saveMany(records);
		System.out.println(profileRepository.findAll());
		
	}
	
	

	
}
