package br.com.alex.apppassvalidator.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LeastOneUpperCaseCharValidationStep extends ValidationStep<String>{

	private static final String regex = ".*[A-Z].*";
	
	@Override
	public boolean validate(String password) {
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(password);  
    	boolean valid = matcher.matches();  
    	
    	if (valid) {
    		log.debug("[" + password + "] Valido");
    		return checkNext(password);
    	} else {
    		log.debug("[" + password + "] Invalido");
    		return false;
    	}
		
	}

}
