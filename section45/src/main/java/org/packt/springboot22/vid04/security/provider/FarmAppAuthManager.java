package org.packt.springboot22.vid04.security.provider;

import java.util.HashSet;
import java.util.Set;

import org.packt.springboot22.vid04.model.Login;
import org.packt.springboot22.vid04.repository.LoginRepository;
import org.packt.springboot22.vid04.repository.PermissionRepository;
import org.packt.springboot22.vid04.repository.PermissionSetsRepository;
import org.packt.springboot22.vid04.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

//@Component
public class FarmAppAuthManager implements AuthenticationManager{

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private PermissionSetsRepository permissionSetsRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println(username);
		System.out.println(password);
		Login login = null;
		try {
			login = loginRepository.findByUsername(username);
		} catch (NullPointerException e) {
			throw new AuthenticationCredentialsNotFoundException("No authorization roles assigned");
		}
		System.out.println("why");
		Set<GrantedAuthority> userAuthorities = createGrantedAuthorities(login.getId());
		System.out.println(userAuthorities);
		if(userAuthorities.size() == 0) {
			throw new AuthenticationCredentialsNotFoundException("No authorization roles assigned");
		}
		
		Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
		String passphrase = encoder.encode(password);
		if(!passphrase.equals(login.getPassphrase())) {
			throw new AuthenticationCredentialsNotFoundException("No authorization roles assigned");
		}
		return new UsernamePasswordAuthenticationToken(username, passphrase, userAuthorities);

		
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
