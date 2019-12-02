package org.packt.springboot22.vid06

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories
class FarmUpApplication

fun main(args: Array<String>) {
	runApplication<FarmUpApplication>(*args)
}
