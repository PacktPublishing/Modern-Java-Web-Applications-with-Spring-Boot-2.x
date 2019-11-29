package org.packt.springboot22.vid03;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.packt.springboot22.vid03.repository.HarvestRepository;
import org.packt.springboot22.vid03.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LocationRepoMockTest {
	
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
	public void testGetAllMarkets() {
		locationRepository.findAll();
	}

}
