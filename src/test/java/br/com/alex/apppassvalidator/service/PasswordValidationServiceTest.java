package br.com.alex.apppassvalidator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PasswordValidationServiceTest {
	
	@Autowired
	private PasswordValidationService passwordValidationService;

	@Test
	void passwordValidationTest1() {
		String password = "";
		boolean valid = passwordValidationService.isValid(password);
		
		assertFalse(valid);
	}
	
	@Test
	void passwordValidationTest2() {
		String password = "aa";
		boolean valid = passwordValidationService.isValid(password);
		
		assertFalse(valid);
	}
	
	@Test
	void passwordValidationTest3() {
		String password = "ab";
		boolean valid = passwordValidationService.isValid(password);
		
		assertFalse(valid);
	}
	
	@Test
	void passwordValidationTest4() {
		String password = "AAAbbbCc";
		boolean valid = passwordValidationService.isValid(password);
		
		assertFalse(valid);
	}
	
	@Test
	void passwordValidationTest5() {
		String password = "AbTp9!foo";
		boolean valid = passwordValidationService.isValid(password);
		
		assertFalse(valid);
	}

	@Test
	void passwordValidationTest6() {
		String password = "AbTp9!foA";
		boolean valid = passwordValidationService.isValid(password);
		
		assertFalse(valid);
	}
	
	@Test
	void passwordValidationTest7() {
		String password = "AbTp9 fok";
		boolean valid = passwordValidationService.isValid(password);
		
		assertFalse(valid);
	}
	
	@Test
	void passwordValidationTest8() {
		String password = "AbTp9!fok";
		boolean valid = passwordValidationService.isValid(password);
		
		assertTrue(valid);
	}
}
