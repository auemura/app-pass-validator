package br.com.alex.apppassvalidator.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alex.apppassvalidator.service.PasswordValidationService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/v1/validate")
@Log4j2
public class PasswordValidationResource {
	
	@Autowired
	private PasswordValidationService passwordValidationService;
	
    @GetMapping("/password")
    public ResponseEntity<Boolean> isValid(@RequestParam("password") String password) {
    	
    	log.info("BEGIN: isValid() password: [" + password + "]");

    	Boolean isValid = passwordValidationService.isValid(password);
    	
    	log.info("Pssword: [" + password + "] | isValid: " + isValid);
    	
    	return ResponseEntity.ok(isValid);
    }
}
