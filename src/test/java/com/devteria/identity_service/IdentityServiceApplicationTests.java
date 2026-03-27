package com.devteria.identity_service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest
@TestPropertySource("/test.properties")
class IdentityServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void hash() {
		String password = "123456";

		// BCrypt — different salt each round, secure
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		String hash1 = passwordEncoder.encode(password);
		String hash2 = passwordEncoder.encode(password);

		log.info("BCrypt round 1: {}", hash1);
		log.info("BCrypt round 2: {}", hash2);
		log.info("Match same password: {}", passwordEncoder.matches(password, hash1));
		log.info("Match wrong password: {}", passwordEncoder.matches("wrong", hash1));
	}
}
