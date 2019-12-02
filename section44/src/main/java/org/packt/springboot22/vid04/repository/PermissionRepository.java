package org.packt.springboot22.vid04.repository;

import org.packt.springboot22.vid04.model.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Long> {

}
