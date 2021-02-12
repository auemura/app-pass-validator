package br.com.alex.apppassvalidator.service.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class NotRepetCharInSetValidationStep extends ValidationStep<String>{
	
	@Override
	public boolean validate(String password) {
		char[] chars = password.toCharArray();
    	
		boolean repeatCharacter = repeatCharacter(chars);
		
    	if (repeatCharacter) {
    		log.debug("[" + password + "] Invalido");
    		return false;
    	} else {
    		log.debug("[" + password + "] Valido");
    		return checkNext(password);
    	}
		
	}
	
	private boolean repeatCharacter(char[] chars) {
		Map<Character, Integer> map = new HashMap<>();
        for(char c : chars) 
        {
            if(map.containsKey(c)) {
                return true;
            } else {
                map.put(c, 1);
            }
        }
        
        return false;
	}
}
