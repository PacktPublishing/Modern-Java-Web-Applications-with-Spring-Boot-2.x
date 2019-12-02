package org.packt.springboot22.vid05.repository;

import java.util.List;

import org.packt.springboot22.vid05.model.PermissionSets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PermissionSetsRepository extends CrudRepository<PermissionSets, Long>{
	
	@Query("SELECT ps FROM PermissionSets ps WHERE ps.loginId = ?1")
	public List<PermissionSets> findAllByLoginId(Long id);
}
