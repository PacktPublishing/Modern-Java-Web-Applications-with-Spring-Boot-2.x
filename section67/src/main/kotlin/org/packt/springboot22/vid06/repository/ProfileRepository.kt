package org.packt.springboot22.vid06.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.packt.springboot22.vid06.model.Profile
import org.springframework.stereotype.Repository

@Repository
interface ProfileRepository : ReactiveCrudRepository<Profile, Long> {
}