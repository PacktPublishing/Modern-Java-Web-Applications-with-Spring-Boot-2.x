package org.packt.springboot22.vid06;

import static org.mockito.Mockito.times;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.packt.springboot22.vid06.model.Harvest;
import org.packt.springboot22.vid06.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest
public class ProfileRESTServiceTests {

	@MockBean
	private HarvestRepository harvestRepository;

	@Autowired
	private WebTestClient webClient;

	@Test
	public void testFindAllHarvest() {
		Harvest h1 = new Harvest();
		h1.setId(121L);
		h1.setName("Bittergurd");
		h1.setDescription("Small and fresh");
		h1.setPrice(50.90F);
		h1.setQty(1000);
		h1.setStatus("fresh");
		h1.setType("vegetable");
		h1.setApprovedDate(LocalDate.now());

		List<Harvest> list = new ArrayList<Harvest>();
		list.add(h1);

		Flux<Harvest> employeeFlux = Flux.fromIterable(list);
		Mockito.when(harvestRepository.findAll()).thenReturn(employeeFlux);
		webClient.get()
		        .uri("/farm/harvest/list")
				.accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk()
				.expectBodyList(Harvest.class);

		Mockito.verify(harvestRepository, times(1)).findAll();
	}

	@Test
	public void testAddHarvest() {
		Harvest h1 = new Harvest();
		h1.setId(121L);
		h1.setName("Bittergurd");
		h1.setDescription("Small and fresh");
		h1.setPrice(50.90F);
		h1.setQty(1000);
		h1.setStatus("fresh");
		h1.setType("vegetable");
		h1.setApprovedDate(LocalDate.now());

		Mockito.when(harvestRepository.save(h1)).thenReturn(Mono.just(h1));

		webClient.post().uri("/farm/harvest/add")
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(h1)).exchange().expectStatus().isOk();

		Mockito.verify(harvestRepository, times(1)).save(h1);

	}

}
