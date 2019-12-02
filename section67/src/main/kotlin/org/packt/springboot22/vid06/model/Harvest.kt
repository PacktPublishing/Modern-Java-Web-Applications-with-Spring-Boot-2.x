package org.packt.springboot22.vid06.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import org.springframework.data.relational.core.mapping.Column

@Table("harvest")
data class Harvest (
	
	@Id val id : Long? = null,
	var name : String,
	var qty : Int,
	var price : Float,
	var description : String,
	var status : String,
	var type : String,
	@Column("approved") var approvedDate : LocalDate
)