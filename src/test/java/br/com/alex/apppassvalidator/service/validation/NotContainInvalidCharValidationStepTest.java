package br.com.alex.apppassvalidator.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class NotContainInvalidCharValidationStepTest {
	
	@InjectMocks
	private NotContainInvalidCharValidationStep notContainInvalidChar;

	@Test
	void notContainInvalidCharTest() {
		String password = "abc";
		boolean valid = notContainInvalidChar.validate(password);
		
		assertTrue(valid);
	}
	
	@Test
	void containInvalidCharTest1() {
		String password = " ";
		boolean valid = notContainInvalidChar.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void containInvalidCharTest2() {
		String password = "a ";
		boolean valid = notContainInvalidChar.validate(password);
		
		assertFalse(valid);
	}
	
	@Test
	void containInvalidCharTest3() {
		String password = " b";
		boolean valid = notContainInvalidChar.validate(password);
		
		assertFalse(valid);
	}

}
