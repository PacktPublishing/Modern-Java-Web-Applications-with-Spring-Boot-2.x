package org.packt.springboot22.vid03.repository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.packt.springboot22.vid03.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

public interface LoginRepository extends CrudRepository<Login, Long>{
	
	@Async
	public Future<Login> findByUsername(String username); 
	
	@Async
	public CompletableFuture<Login> findOneByUsername(String username); 
	
	@Async
	public ListenableFuture<Login> findOneById(Long id);
}
