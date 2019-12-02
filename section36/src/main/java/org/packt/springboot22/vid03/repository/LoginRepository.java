package org.packt.springboot22.vid03.repository;

import java.util.List;

import org.packt.springboot22.vid03.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Long>{

	public List<Login> findByUsername(String username);
}
