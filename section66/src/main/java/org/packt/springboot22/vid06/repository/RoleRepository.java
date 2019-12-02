package org.packt.springboot22.vid06.repository;

import org.packt.springboot22.vid06.model.Role;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RoleRepository extends ReactiveCrudRepository<Role, Long> {

}
