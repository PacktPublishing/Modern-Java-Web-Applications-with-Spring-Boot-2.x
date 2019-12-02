package org.packt.springboot22.vid06.security;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.packt.springboot22.vid06.model.Login;
import org.packt.springboot22.vid06.repository.PermissionRepository;
import org.packt.springboot22.vid06.repository.PermissionSetsRepository;
import org.packt.springboot22.vid06.repository.ProfileRepository;
import org.packt.springboot22.vid06.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ProfileUserDetailService implements ReactiveUserDetailsService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private PermissionSetsRepository permissionSetsRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Set<GrantedAuthority> createGrantedAuthorities(Long loginId){
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		return grantedAuthorities;
		
	}

	@Override
	public Mono<UserDetails> findByUsername(String username) {
		Mono<Login> login = profileRepository.findByUsername(username);
		Set<GrantedAuthority> userAuthorities = null;
		UserDetails user = null;
		try {
			userAuthorities = createGrantedAuthorities(login.map((p)->p.getId()).toFuture().get());
			user = (UserDetails) (new User(login.map((p)->p.getUsername()).toFuture().get(),
					login.map((p)->p.getPassphrase()).toFuture().get(), userAuthorities));
			return Mono.just(user);
		} catch (InterruptedException e) {		
		} catch (ExecutionException e) {
		}
		return Mono.just(user);
	}

}
