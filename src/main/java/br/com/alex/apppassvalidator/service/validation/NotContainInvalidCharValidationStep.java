package br.com.alex.apppassvalidator.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class NotContainInvalidCharValidationStep extends ValidationStep<String>{

	private static final String regex = ".* .*"; 
	
	@Override
	public boolean validate(String password) {
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(password);  
    	boolean containInvalidChar = matcher.matches();  
    	
    	if (containInvalidChar) {
    		log.debug("[" + password + "] Invalido");
    		return false;
    	} else {
    		log.debug("[" + password + "] Valido");
    		return checkNext(password);
    	}
		
	}

}
