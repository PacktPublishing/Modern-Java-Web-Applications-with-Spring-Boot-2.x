package org.packt.springboot22.vid04;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class GeneratePassphraseTest {

	@Test
	void contextLoads() {
		Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}
	
	@Test
	public void bcryptgenerator() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}

}
