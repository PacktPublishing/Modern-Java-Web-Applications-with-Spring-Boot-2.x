package org.packt.springboot22.vid04.security;

import java.util.HashSet;
import java.util.Set;

import org.packt.springboot22.vid04.model.Login;
import org.packt.springboot22.vid04.repository.LoginRepository;
import org.packt.springboot22.vid04.repository.PermissionRepository;
import org.packt.springboot22.vid04.repository.PermissionSetsRepository;
import org.packt.springboot22.vid04.repository.RoleRepository;
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
	
	@Autowired
	private PermissionSetsRepository permissionSetsRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = null;
		try {
			login = loginRepository.findByUsername(username);
		} catch (NullPointerException e) {
			login = new Login();
		}
		
		Set<GrantedAuthority> userAuthorities = createGrantedAuthorities(login.getId());
		return new User(login.getUsername(), login.getPassphrase().trim(), userAuthorities);
	}
	
	public Set<GrantedAuthority> createGrantedAuthorities(Long loginId){
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		permissionSetsRepository.findAllByLoginId(loginId).forEach((ps)->{
			String rolePerm = String.join(" ", roleRepository.findById(ps.getRoleId()).get().getName(),
					           permissionRepository.findById(ps.getPermId()).get().getName());
			grantedAuthorities.add(new SimpleGrantedAuthority(rolePerm));
		});
		
		return grantedAuthorities;
		
	}

}
