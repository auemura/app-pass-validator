package br.com.alex.apppassvalidator.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
class LeastOneLowerCaseCharValidationStepTest {

	@InjectMocks
	private LeastOneLowerCaseCharValidationStep leastOneLowerCaseCharValidationStep;
	
	@Test
	void leastOneLowerCaseCharTest1() {
		String password = "a";
		boolean valid = leastOneLowerCaseCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneLowerCaseCharTest2() {
		String password = "a0";
		boolean valid = leastOneLowerCaseCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneLowerCaseCharTest3() {
		String password = "1a3";
		boolean valid = leastOneLowerCaseCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneLowerCaseCharTest4() {
		String password = "1234abcgdf1234";
		boolean valid = leastOneLowerCaseCharValidationStep.validate(password);
		
		assertTrue(valid);
	}

	@Test
	void notContainsLowerCaseCharTest1() {
		String password = "ABC12346!$@$#";
		boolean valid = leastOneLowerCaseCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void notContainsLowerCaseCharTest2() {
		String password = " ";
		boolean valid = leastOneLowerCaseCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void notContainsLowerCaseCharTest3() {
		String password = "";
		boolean valid = leastOneLowerCaseCharValidationStep.validate(password);
		
		assertFalse(valid);
	}

}
