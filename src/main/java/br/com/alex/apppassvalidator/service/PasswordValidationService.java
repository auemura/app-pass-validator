package br.com.alex.apppassvalidator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alex.apppassvalidator.service.validation.NotContainInvalidCharValidationStep;
import br.com.alex.apppassvalidator.service.validation.LeastOneDigitValidationStep;
import br.com.alex.apppassvalidator.service.validation.LeastOneLowerCaseCharValidationStep;
import br.com.alex.apppassvalidator.service.validation.LeastOneSpecialCharValidationStep;
import br.com.alex.apppassvalidator.service.validation.LeastOneUpperCaseCharValidationStep;
import br.com.alex.apppassvalidator.service.validation.MinNineCharValidationStep;
import br.com.alex.apppassvalidator.service.validation.NotRepetCharInSetValidationStep;

@Service
public class PasswordValidationService {

	@Autowired
	private MinNineCharValidationStep minNineCharValidation;
	@Autowired
	private LeastOneDigitValidationStep leastOneDigitValidation;
	@Autowired
	private LeastOneLowerCaseCharValidationStep leastOneLowerCaseCharValidation;
	@Autowired
	private LeastOneUpperCaseCharValidationStep leastOneUpperCaseCharValidation;
	@Autowired
	private LeastOneSpecialCharValidationStep leastOneSpecialCharValidation;
	@Autowired
	private NotRepetCharInSetValidationStep notRepetCharInSetValidation;
	@Autowired
	private NotContainInvalidCharValidationStep containInvalidCharValidationStep;
	
	public boolean isValid (String password) {
		
		return minNineCharValidation
				.nextValidation(leastOneDigitValidation)
				.nextValidation(leastOneLowerCaseCharValidation)
				.nextValidation(leastOneUpperCaseCharValidation)
				.nextValidation(leastOneSpecialCharValidation)
				.nextValidation(notRepetCharInSetValidation)
				.nextValidation(containInvalidCharValidationStep)
				.getFirst()
				.validate(password);
	}
}
