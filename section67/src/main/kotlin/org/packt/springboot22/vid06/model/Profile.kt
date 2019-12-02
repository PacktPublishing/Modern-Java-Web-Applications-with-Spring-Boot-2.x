package org.packt.springboot22.vid06.model

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate

@Table("signup")
data class Profile (
	
	@Id val id : Long? = null,
	var name : String,
	var mobile : String,
	var address : String,
	var email : String,
	var username : String,
	var password : String,
	var approved : Boolean,
	@Column("birthday") var bday : LocalDate

)