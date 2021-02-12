package br.com.alex.apppassvalidator.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
class LeastOneDigitValidationStepTest {

	@InjectMocks
	private LeastOneDigitValidationStep leastOneDigitValidationStep;
	
	@Test
	void leastOneDigitTest1() {
		String password = "abc0";
		boolean valid = leastOneDigitValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneDigitTest2() {
		String password = "0abc";
		boolean valid = leastOneDigitValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneDigitTest3() {
		String password = "ab0c";
		boolean valid = leastOneDigitValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void leastOneDigitTest4() {
		String password = "ab12340c";
		boolean valid = leastOneDigitValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void notContainsDigitTest1() {
		String password = "abc";
		boolean valid = leastOneDigitValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void notContainsDigitTest2() {
		String password = "";
		boolean valid = leastOneDigitValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void notContainsDigitTest3() {
		String password = "!@$#%";
		boolean valid = leastOneDigitValidationStep.validate(password);
		
		assertFalse(valid);
	}

}
