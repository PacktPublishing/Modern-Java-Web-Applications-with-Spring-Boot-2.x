package org.packt.springboot22.vid03;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.packt.springboot22.vid03.model.Harvest;
import org.packt.springboot22.vid03.repository.HarvestRepository;
import org.packt.springboot22.vid03.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class HarvestRepoMockTest {
	
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
	
	@Test
	public void testAddListHarvest() {
		Harvest h1 = new Harvest();
		h1.setId(101L);
		h1.setName("Bittergurd");
		h1.setDescription("Small and fresh");
		h1.setPrice(50.90F);
		h1.setQty(1000);
		h1.setStatus("fresh");
		h1.setType("vegetable");
		h1.setApprovedDate(LocalDate.now());
		
		harvestRepository.save(h1);
		harvestRepository.findByNameLike("%gurd%").forEach((h)->{
			System.out.println(h.getDescription());
		});
	}

}
