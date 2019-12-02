package org.packt.springboot22.vid06.repository;

import org.packt.springboot22.vid06.model.Permission;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PermissionRepository extends ReactiveCrudRepository<Permission, Long> {

}
