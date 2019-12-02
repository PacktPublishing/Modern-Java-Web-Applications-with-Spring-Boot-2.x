package org.packt.springboot22.vid06.controller

import kotlinx.coroutines.flow.Flow
import org.packt.springboot22.vid06.model.Harvest
import org.packt.springboot22.vid06.repository.HarvestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlinx.coroutines.FlowPreview
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping("/farm")
class HarvestRestController {
	
	@Autowired
	lateinit var harvestRepository : HarvestRepository;
	
	@FlowPreview
	@GetMapping("/harvest/list")
    fun findAllHarvest() : Flow<Harvest> = harvestRepository.findAll()
	
	@GetMapping("/harvest/{id}")
    suspend fun findHarvest(@PathVariable id: Long): Harvest? =
            harvestRepository.findHarvestById(id) ?: throw NullPointerException()
	
    @PostMapping("/harvest/save")
    suspend fun save(@RequestBody harvest: Harvest) =
            harvestRepository.save(harvest)
	
	@DeleteMapping("/harvest/delete/{id}")
    suspend fun save(@PathVariable id: Long) =
            harvestRepository.deleteHarvest(id)
  
	
  
	
}