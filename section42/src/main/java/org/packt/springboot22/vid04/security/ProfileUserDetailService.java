package org.packt.springboot22.vid04.security;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.packt.springboot22.vid04.model.Login;
import org.packt.springboot22.vid04.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProfileUserDetailService implements UserDetailsService{

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = null;
		try {
			login = loginRepository.findByUsername(username).get();
		} catch (InterruptedException | ExecutionException e) {
			login = new Login();
		}
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		return new User(login.getUsername(), login.getPassphrase().trim(), grantedAuthorities);
	}

}
