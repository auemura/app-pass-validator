package br.com.alex.apppassvalidator.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
class NotRepetCharInSetValidationStepTest {
	
	@InjectMocks
	private NotRepetCharInSetValidationStep notRepetCharInSetValidationStep;

	@Test
	void notContainRepetCharInSetTest1() {
		String password = "abc";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void notContainRepetCharInSetTest2() {
		String password = "123";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertTrue(valid);
	}

	@Test
	void notContainRepetCharInSetTest3() {
		String password = "!@#";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void containRepetCharInSetTest1() {
		String password = "aa";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void containRepetCharInSetTest2() {
		String password = "00";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void containRepetCharInSetTest3() {
		String password = "!!";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void containRepetCharInSetTest4() {
		String password = "abcaaabc";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void containRepetCharInSetTest5() {
		String password = "abc!=abc0";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void containRepetCharInSetTest6() {
		String password = "!abcdef!";
		boolean valid = notRepetCharInSetValidationStep.validate(password);
		
		assertFalse(valid);
	}
}
