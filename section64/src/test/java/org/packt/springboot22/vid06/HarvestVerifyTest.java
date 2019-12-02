package org.packt.springboot22.vid06;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.packt.springboot22.vid06.model.Harvest;
import org.packt.springboot22.vid06.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HarvestVerifyTest {
	
	@Autowired
	private HarvestRepository harvestRepository;
	
	@Test
	public void addHarvestTest() {
		Harvest h1 = new Harvest();
		h1.setId(121L);
		h1.setName("Bittergurd");
		h1.setDescription("Small and fresh");
		h1.setPrice(50.90F);
		h1.setQty(1000);
		h1.setStatus("fresh");
		h1.setType("vegetable");
		h1.setApprovedDate(LocalDate.now());
		
		StepVerifier.create(harvestRepository.addHarvest(h1))
		    .verifyComplete();
	}
	
	@Test
	public void deleteHarvestTest() {
		StepVerifier
		   .create(harvestRepository.delHarvest(130L))
		   .verifyComplete();
	}

}
