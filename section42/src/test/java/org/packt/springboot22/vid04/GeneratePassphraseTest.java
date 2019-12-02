package org.packt.springboot22.vid04;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootTest
public class GeneratePassphraseTest {

	@Test
	public void generatePbkdf2() {
		Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}

}
