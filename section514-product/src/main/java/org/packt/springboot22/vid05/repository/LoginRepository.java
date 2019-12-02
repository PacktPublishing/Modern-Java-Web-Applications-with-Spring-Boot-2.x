package org.packt.springboot22.vid05.repository;

import java.util.concurrent.CompletableFuture;

import org.packt.springboot22.vid05.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

public interface LoginRepository extends CrudRepository<Login, Long>{

	
	public Login findByUsername(String username); 
	public Login findByUsernameAndPassword(String username, String password);
	
	@Async
	public CompletableFuture<Login> findOneByUsername(String username); 
	@Async
	public ListenableFuture<Login> findOneById(Long id);
}
