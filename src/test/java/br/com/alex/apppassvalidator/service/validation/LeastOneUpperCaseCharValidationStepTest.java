package br.com.alex.apppassvalidator.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
class LeastOneUpperCaseCharValidationStepTest {

	@InjectMocks
	private LeastOneUpperCaseCharValidationStep leastOneUpperCaseCharValidationStep;
	
	@Test
	void leastOneUpperCaseCharTest1() {
		String password = "A";
		boolean valid = leastOneUpperCaseCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneUpperCaseCharTest2() {
		String password = "abc!@#012Aabc!@#012";
		boolean valid = leastOneUpperCaseCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneUpperCaseCharTest3() {
		String password = "ABCDE";
		boolean valid = leastOneUpperCaseCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void notContainsUpperCaseCharTest1() {
		String password = "abc012!@#";
		boolean valid = leastOneUpperCaseCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void notContainsUpperCaseCharTest2() {
		String password = "";
		boolean valid = leastOneUpperCaseCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
}
