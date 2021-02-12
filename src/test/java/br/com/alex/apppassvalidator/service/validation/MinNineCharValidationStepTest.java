package br.com.alex.apppassvalidator.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
class MinNineCharValidationStepTest {

	@InjectMocks 
	private MinNineCharValidationStep minNineCharValidationStep;
	
	@Test
	void minNineCharTest1() {
		String password = "123456789";
		boolean valid = minNineCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void minNineCharTest2() {
		String password = "0123456789012";
		boolean valid = minNineCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void minNineCharTest3() {
		String password = "abcdefghi";
		boolean valid = minNineCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void minNineCharTest4() {
		String password = "!@#$%^&*()-+";
		boolean valid = minNineCharValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void lessNineCharTest1() {
		String password = "";
		boolean valid = minNineCharValidationStep.validate(password);
		
		assertFalse(valid);
	}

	@Test
	void lessNineCharTest2() {
		String password = "12345678";
		boolean valid = minNineCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void lessNineCharTest3() {
		String password = "abcdefgh";
		boolean valid = minNineCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void lessNineCharTest4() {
		String password = "!@#$%^&*";
		boolean valid = minNineCharValidationStep.validate(password);
		
		assertFalse(valid);
	}
}
