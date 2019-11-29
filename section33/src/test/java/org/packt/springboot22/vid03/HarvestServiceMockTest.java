package org.packt.springboot22.vid03;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid03.config.FarmUpMongoConfig;
import org.packt.springboot22.vid03.model.Harvest;
import org.packt.springboot22.vid03.repository.HarvestCustomRepositoryImpl;
import org.packt.springboot22.vid03.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.MongoClient;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class HarvestServiceMockTest {
	
	@Autowired
	private HarvestRepository harvestRepository;
	
	@Autowired
	private MongoClient mongoClient;
	
	
	
	@Test
	public void testCustomHarvest() {
		
		Harvest h1 = new Harvest();
		h1.setId(106L);
		h1.setName("Bittergurd");
		h1.setDescription("Small and fresh");
		h1.setPrice(50.90F);
		h1.setQty(1000);
		h1.setStatus("fresh");
		h1.setType("vegetable");
		h1.setApprovedDate(LocalDate.now());
		
		harvestRepository.save(h1);
		
	    harvestRepository.updateQtyPrice(106L, 6789.99F, 500);
		System.out.println(harvestRepository.findAll());
	}


}
