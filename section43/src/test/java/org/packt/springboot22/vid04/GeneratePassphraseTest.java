package org.packt.springboot22.vid04;

import java.security.SecureRandom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
public class GeneratePassphraseTest {
	
	@Test
	public void generatePbkdf2() {
		Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}
	
	@Test
	public void generateStrongPbkdf2() {
		Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder("packt", 1000, 64);
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}
	
	@Test
	public void generateBCrypt() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}
	
	@Test
	public void generateStrongBCrypt() {
		SecureRandom random = new SecureRandom(new byte[] {10, 20, 30});
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(15, random);
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}

	@Test
	public void generateSCrypt() {
		SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}
	
	@Test
	public void generateStrongSCrypt() {
		SCryptPasswordEncoder encoder = new SCryptPasswordEncoder(16384, 16 , 5, 64, 128);
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}
	
	@Test
	public void generateDefaultArgon2() {
		Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}
	
	@Test
	public void generateStrongArgon2() {
		Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(10, 128, 5, 16, 1000 );
		String passphrase = encoder.encode("sjctrags");
		System.out.println(passphrase);
	}
	
	

}
