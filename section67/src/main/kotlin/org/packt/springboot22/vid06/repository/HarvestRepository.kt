package org.packt.springboot22.vid06.repository

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import org.packt.springboot22.vid06.model.Harvest
import org.springframework.data.r2dbc.core.*
import kotlinx.coroutines.reactive.*
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.stereotype.Repository

@Repository
class HarvestRepository(private val client: DatabaseClient){
	
	@FlowPreview
	fun findAll(): Flow<Harvest> =
            client.select().from("harvest")
            .asType<Harvest>()
			.fetch()
			.flow();
	
	suspend fun findHarvestById(id: Long): Harvest? =
	        client.execute("SELECT * FROM harvest WHERE id = $1")
	          .bind(0, id)
	          .`as`(Harvest::class.java)
	          .fetch()
	          .one()
			  .awaitFirstOrNull();
 
    suspend fun deleteHarvest(id: Long) =
            client.execute("DELETE FROM harvest WHERE id = $1")
				.bind(0, id)
                .fetch()
                .rowsUpdated()
                .awaitSingle()
	
    suspend fun save(harvest: Harvest) =
            client.insert()
                 .into<Harvest>()
                 .table("harvest")
                 .using(harvest)
                 .await()
          
}