package org.packt.springboot22.vid03.repository;

import org.packt.springboot22.vid03.model.Login;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "login", path = "login")
public interface LoginRepository extends PagingAndSortingRepository<Login, Long>{

	
}
