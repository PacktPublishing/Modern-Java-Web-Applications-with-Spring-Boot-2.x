package org.packt.springboot22.vid03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.packt.springboot22.vid03.model.Login;
import org.packt.springboot22.vid03.model.Profile;
import org.packt.springboot22.vid03.repository.LoginRepository;
import org.packt.springboot22.vid03.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SignupRepoMockTest {
	
	@Autowired 
	private DataSource dataSource;
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private EntityManager entityManager;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	
	
	@Test
	public void testAddProfile() {
		Profile p = new Profile();
		p.setId(400L);
		p.setName("Gina Gomez");
		p.setAddress("London");
		p.setEmail("ging@gmail.com");
		p.setMobile("45945894");
		p.setUsername("ging");
		p.setPassword("ging@37");
		p.setApproved(true);
		p.setBday(LocalDate.now());
		
		profileRepository.save(p);
		profileRepository.findProfiles().stream().forEach((profile)->{
			System.out.printf("%d %-30s %-20s %-20s %-20s \n", 
					profile.getId(), profile.getName(), profile.getUsername(), profile.getPassword(), profile.getEmail());
			
		});
	}
	
	@Test
	public void testAddMultipleProfiles() {
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
		
		List<Profile> tbSignup = new ArrayList<>();
		tbSignup.add(p1);
		tbSignup.add(p2);
		
		profileRepository.saveAll(tbSignup);
		profileRepository.findProfiles().stream().forEach((profile)->{
			System.out.printf("%d %-30s %-20s %-20s %-20s \n", 
					profile.getId(), profile.getName(), profile.getUsername(), profile.getPassword(), profile.getEmail());
			
		});
	}
	
	@Test
	public void testAddProfileWithRel() {
		Login login = new Login();
		login.setId(201L);
		login.setUsername("ging");
		login.setPassword("ging@37");
		login.setPassphrase("");
		
		
		Profile p = new Profile();
		p.setId(400L);
		p.setName("Gina Gomez");
		p.setAddress("London");
		p.setEmail("ging@gmail.com");
		p.setMobile("45945894");
		p.setUsername("ging");
		p.setPassword("ging@37");
		p.setApproved(true);
		p.setBday(LocalDate.now());;
			
		profileRepository.save(p);
		
		login.setProfile(p);
		loginRepository.save(login);
		
		try {
			System.out.println(loginRepository.findByUsername("ging").get().getPassword());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCustomUpdateProfile() {
		Profile p = new Profile();
		p.setId(400L);
		p.setName("Gina Gomez");
		p.setAddress("London");
		p.setEmail("ging@gmail.com");
		p.setMobile("45945894");
		p.setUsername("ging");
		p.setPassword("ging@37");
		p.setApproved(true);
		p.setBday(LocalDate.now());
		
		profileRepository.save(p);
		
		profileRepository.updateByUsername("Ginky Lopez", "ging");
		profileRepository.findProfiles().stream().forEach((profile)->{
			System.out.printf("%d %-30s %-20s %-20s %-20s \n", 
					profile.getId(), profile.getName(), profile.getUsername(), profile.getPassword(), profile.getEmail());
			
		});
	}
	
	@Test
	public void testCustomDeleteProfile() {
		Profile p = new Profile();
		p.setId(400L);
		p.setName("Gina Gomez");
		p.setAddress("London");
		p.setEmail("ging@gmail.com");
		p.setMobile("45945894");
		p.setUsername("ging");
		p.setPassword("ging@37");
		p.setApproved(true);
		p.setBday(LocalDate.now());
		
		profileRepository.save(p);
		
		profileRepository.deleteByUsername("ging");
		profileRepository.findProfiles().stream().forEach((profile)->{
			System.out.printf("%d %-30s %-20s %-20s %-20s \n", 
					profile.getId(), profile.getName(), profile.getUsername(), profile.getPassword(), profile.getEmail());
			
		});
	}
	
	@Test
	public void testGetProfileStream() {
		profileRepository.findStreamProfiles().forEach((profile)->{
			System.out.printf("%d %-30s %-20s %-20s %-20s \n", 
					profile.getId(), profile.getName(), profile.getUsername(), profile.getPassword(), profile.getEmail());
			
		});
	}
	
	@Test
	public void testGetProfileByName() {
		Profile p1 = new Profile();
		p1.setId(200L);
		p1.setName("Jean Grey");
		p1.setAddress("Makati");
		p1.setEmail("jgrey@gmail.com");
		p1.setMobile("45945894");
		p1.setUsername("jeangrey");
		p1.setPassword("grey");
		p1.setApproved(true);
		p1.setBday(LocalDate.now());
		
		Profile p2 = new Profile();
		p2.setId(500L);
		p2.setName("Sherwin Trags");
		p2.setAddress("Pasig");
		p2.setEmail("sjctrags@gmail.com");
		p2.setMobile("4464646");
		p2.setUsername("sjctrags");
		p2.setPassword("sjctrags");
		p2.setApproved(false);
		p2.setBday(LocalDate.now());
		
		
		profileRepository.save(p1);
		profileRepository.save(p2);
		System.out.println(profileRepository.findByProfileName("Sherwin Trags"));
	}
	
	@Test
	public void testFindLoginProfile() {
		Profile p1 = new Profile();
		p1.setId(200L);
		p1.setName("Jean Grey");
		p1.setAddress("Makati");
		p1.setEmail("jgrey@gmail.com");
		p1.setMobile("45945894");
		p1.setUsername("jeangrey");
		p1.setPassword("grey");
		p1.setApproved(true);
		p1.setBday(LocalDate.now());
		
		Profile p2 = new Profile();
		p2.setId(500L);
		p2.setName("Sherwin Trags");
		p2.setAddress("Pasig");
		p2.setEmail("sjctrags@gmail.com");
		p2.setMobile("4464646");
		p2.setUsername("sjctrags");
		p2.setPassword("sjctrags");
		p2.setApproved(false);
		p2.setBday(LocalDate.now());
		
		
		profileRepository.save(p1);
		profileRepository.save(p2);
		System.out.println(profileRepository.findByUsernameStartingWith("sjct"));
		
	}
	
	

	
}
