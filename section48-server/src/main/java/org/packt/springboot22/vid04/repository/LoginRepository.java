package org.packt.springboot22.vid04.repository;

import java.util.concurrent.CompletableFuture;

import org.packt.springboot22.vid04.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

public interface LoginRepository extends CrudRepository<Login, Long>{

	
	Login findByUsername(String username); 
	@Async
	CompletableFuture<Login> findOneByUsername(String username); 
	@Async
	ListenableFuture<Login> findOneById(Long id);
}
