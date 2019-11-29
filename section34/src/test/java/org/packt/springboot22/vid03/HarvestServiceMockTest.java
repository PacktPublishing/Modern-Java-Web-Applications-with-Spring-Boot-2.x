package org.packt.springboot22.vid03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid03.model.Basket;
import org.packt.springboot22.vid03.model.Harvest;
import org.packt.springboot22.vid03.model.Login;
import org.packt.springboot22.vid03.model.Profile;
import org.packt.springboot22.vid03.model.QHarvest;
import org.packt.springboot22.vid03.repository.BasketRepository;
import org.packt.springboot22.vid03.repository.HarvestQueryDslRepository;
import org.packt.springboot22.vid03.repository.HarvestRepository;
import org.packt.springboot22.vid03.repository.LocationRepository;
import org.packt.springboot22.vid03.repository.LoginRepository;
import org.packt.springboot22.vid03.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class HarvestServiceMockTest {
	
	@Autowired 
	private DataSource dataSource;
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private EntityManager entityManager;
	
	@Autowired 
	private HarvestRepository harvestRepository;
	
	@Autowired 
	private LocationRepository locationRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private BasketRepository basketRepository;
	
	@Autowired
	private HarvestQueryDslRepository harvestQueryDslRepository;
	
	@Test
	public void testBasketPurchaseInnerJoin() {
		Login login = new Login();
		login.setId(100L);
		login.setUsername("jeangrey");
		login.setPassword("grey");
		login.setPassphrase("fewetertrtreytr");
		
		Profile p = new Profile();
		p.setId(200L);
		p.setName("Jean Grey");
		p.setAddress("Makati");
		p.setEmail("jgrey@gmail.com");
		p.setMobile("45945894");
		p.setUsername("jeangrey");
		p.setPassword("grey");
		p.setApproved(true);
		p.setBday(LocalDate.now());
			
		profileRepository.save(p);
		profileRepository.findStreamProfiles()
		             .map(profile -> profile.getName()).forEach(System.out::println);
		loginRepository.save(login);
		try {
			System.out.println(loginRepository.findByUsername("jeangrey")
					.get().getPassword());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		Harvest h1 = new Harvest();
		h1.setId(101L);
		h1.setName("Bittergurd");
		h1.setDescription("Small and fresh");
		h1.setPrice(50.90F);
		h1.setQty(1000);
		h1.setStatus("fresh");
		h1.setType("vegetable");
		h1.setApprovedDate(LocalDate.now());
		
		Harvest h2 = new Harvest();
		h2.setId(201L);
		h2.setName("Apple");
		h2.setDescription("Red and Fresh");
		h2.setPrice(90.90F);
		h2.setQty(6000);
		h2.setStatus("amorous");
		h2.setType("fruits");
		h2.setApprovedDate(LocalDate.now());
		
		harvestRepository.save(h1);
		harvestRepository.save(h2);
		harvestRepository.findByNameLike("%gurd%").forEach((h)->{
			System.out.println(h.getDescription());
		});
		
		
		Basket b1 = new Basket();
		b1.setId(10L);
		b1.setHid(101L);
		b1.setUserid(100L);
		b1.setPurchasedDate(LocalDate.now());
		b1.setApprovedDate(LocalDate.now());
		b1.setApprovedBy("Aling Tess");
		b1.setQty(10);
			
		Basket b2 = new Basket();
		b2.setId(20L);
		b2.setHid(101L);
		b2.setUserid(100L);
		b2.setPurchasedDate(LocalDate.now());
		b2.setApprovedDate(LocalDate.now());
		b2.setApprovedBy("Owen");
		b2.setQty(20);
			
		basketRepository.save(b1);
		basketRepository.save(b2);
		
		System.out.println(basketRepository.fetchHarvestBasketRightJoin());	
	}
	
	
	@Test
	public void testFindProfilesSortByName() {
		List<Order> sorts = new ArrayList<>();
		sorts.add(new Sort.Order(Sort.Direction.DESC,"username"));
		List<Profile> records = profileRepository.findProfilesByNameSorted("%r%", new Sort(sorts) {});
		records.stream().forEach((p) ->{
			System.out.printf("%d %-20s %-10s %-10s %-10s \n", 
					p.getId(), p.getName(), p.getUsername(), p.getPassword(), p.getEmail());
		});
	}
	
	@Test
	public void testFindProfilesByPages() {
		Pageable sortedByName = 
				  PageRequest.of(0, 2, Sort.by("username").descending());
		Page<Profile> pages = profileRepository.findProfilesPages(sortedByName);
		System.out.println(pages.getTotalPages());
		List<Profile> list = pages.getContent();
		int counter = 0;
		while(counter < pages.getTotalPages()) {
			System.out.println("-----------page #" + pages.getNumber() + "---------------");
			list.stream().forEach((p)->{
				System.out.printf("%d %-20s %-10s %-10s %-10s \n", 
						p.getId(), p.getName(), p.getUsername(), p.getPassword(), p.getEmail());
			});
			System.out.println("----------------------");
			Page<Profile> nextPage = profileRepository.findProfilesPages(pages.nextPageable());
			list = nextPage.getContent();
			pages = nextPage;
			counter++;
		}
	}
	
	@Test
	public void testfindProfileByUsername() {
		List<Order> sorts = new ArrayList<>();
		sorts.add(new Sort.Order(Sort.Direction.DESC,"username"));
		Pageable pages =  PageRequest.of(0, 2, Sort.by("username").descending());
		Slice<Profile> sliceProfiles = null;
		while(true) {
			sliceProfiles = profileRepository.findProfileByUsername("sjctrags", pages);
			List<Profile> listProfiles = sliceProfiles.getContent();
			System.out.println("-----------page #" + sliceProfiles.getNumber() + "---------------");
			listProfiles.stream().forEach((p)->{
				System.out.printf("%d %-20s %-10s %-10s %-10s \n", 
						p.getId(), p.getName(), p.getUsername(), p.getPassword(), p.getEmail());
			});
			System.out.println("----------------------");
			if (!sliceProfiles.hasNext()) {
	              break;
	          }
			pages = sliceProfiles.nextPageable();
			
		}
	}
	
	@Test
    public void testQueryDsl() {
		Harvest h1 = new Harvest();
		h1.setId(101L);
		h1.setName("Bittergurd");
		h1.setDescription("Small and fresh");
		h1.setPrice(50.90F);
		h1.setQty(1000);
		h1.setStatus("fresh");
		h1.setType("vegetable");
		h1.setApprovedDate(LocalDate.now());
		
		Harvest h2 = new Harvest();
		h2.setId(201L);
		h2.setName("Apple");
		h2.setDescription("Red and Fresh");
		h2.setPrice(90.90F);
		h2.setQty(6000);
		h2.setStatus("amorous");
		h2.setType("fruits");
		h2.setApprovedDate(LocalDate.now());
		
		harvestRepository.save(h1);
		harvestRepository.save(h2);
  
		QHarvest qHarvest = QHarvest.harvest;
		BooleanExpression booleanExpression = qHarvest.id.eq(101L);
        OrderSpecifier<String> orderSpecifier = qHarvest.name.asc();
        Iterable<Harvest> cities2 = harvestQueryDslRepository.findAll(booleanExpression, orderSpecifier);
        System.out.println(cities2);
   
	}
	
	@Test
	public void testFindByName() {
		Harvest h1 = new Harvest();
		h1.setId(101L);
		h1.setName("Bittergurd");
		h1.setDescription("Small and fresh");
		h1.setPrice(50.90F);
		h1.setQty(1000);
		h1.setStatus("fresh");
		h1.setType("vegetable");
		h1.setApprovedDate(LocalDate.now());
		
		Harvest h2 = new Harvest();
		h2.setId(201L);
		h2.setName("Apple");
		h2.setDescription("Red and Fresh");
		h2.setPrice(90.90F);
		h2.setQty(6000);
		h2.setStatus("amorous");
		h2.setType("fruits");
		h2.setApprovedDate(LocalDate.now());
		
		harvestRepository.save(h1);
		harvestRepository.save(h2);
		
		harvestQueryDslRepository.findByName("Apple").forEach((h)->{
			System.out.printf("%d %-10s %-10f %-10d %-20s \n", 
					h.getId(), h.getName(), h.getPrice(), h.getQty(), h.getDescription());
	     });
	}
	
	
}
