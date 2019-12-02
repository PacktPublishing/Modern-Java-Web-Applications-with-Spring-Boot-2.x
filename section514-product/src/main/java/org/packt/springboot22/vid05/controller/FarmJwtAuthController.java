package org.packt.springboot22.vid05.controller;

import org.packt.springboot22.vid05.security.FarmUpAuthRequest;
import org.packt.springboot22.vid05.security.FarmUpAuthResponse;
import org.packt.springboot22.vid05.security.FarmUpJwtTokenUtil;
import org.packt.springboot22.vid05.security.ProfileUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/farm")
public class FarmJwtAuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private FarmUpJwtTokenUtil jwtTokenUtil;

	@Autowired
	private ProfileUserDetailService profileUserDetailService;
	  

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody FarmUpAuthRequest reqBody) throws Exception {

		final UserDetails userDetails = profileUserDetailService
				.loadUserByUsername(reqBody.getUsername());
			
		authenticate(reqBody.getUsername(), reqBody.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new FarmUpAuthResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
