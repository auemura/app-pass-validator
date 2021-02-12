package br.com.alex.apppassvalidator.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
class LeastOneSpecialCharValidationStepTest {

	@InjectMocks
	private LeastOneSpecialCharValidationStep leastOneSpecialCharValidationStep;
	
	@Test
	void leastOneSpecialCharTest1() {
		String password = "!";
		boolean valid = leastOneSpecialCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneSpecialCharTest2() {
		String password = "!@#$%^&*()-+";
		boolean valid = leastOneSpecialCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneSpecialCharTest3() {
		String password = "abc012@";
		boolean valid = leastOneSpecialCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneSpecialCharTest4() {
		String password = "abc012@123abc";
		boolean valid = leastOneSpecialCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void notContainsSpecialCharTest1() {
		String password = "";
		boolean valid = leastOneSpecialCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void notContainsSpecialCharTest2() {
		String password = "abc";
		boolean valid = leastOneSpecialCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void notContainsSpecialCharTest3() {
		String password = "abc1234abc";
		boolean valid = leastOneSpecialCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
}
