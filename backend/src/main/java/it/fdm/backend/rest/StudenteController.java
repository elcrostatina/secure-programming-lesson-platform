package it.fdm.backend.rest;

import it.fdm.backend.entities.ValidateTokenDto;
import it.fdm.backend.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudenteController {
	private MailService mailService;
	
	@Autowired
	public StudenteController(MailService mailService) {
		super();
		this.mailService = mailService;
	}
	
	@PostMapping("/validate-token")
	public ValidateTokenDto validateToken() {
		ValidateTokenDto response = new ValidateTokenDto();
		response.setPasswordToken("TODO ?????????");
		
		return response;
	}
	
	// @PostMapping("/create-student")
	
	
	// @PostMapping("/account-confirm")
	// invio password e password confirm + ValidateToken
	

	
	/*
	@PostMapping("/validate-token")
	public ResponseEntity<ValidateTokenDto> validateToken() {
		ValidateTokenDto response = new ValidateTokenDto();
		response.setPasswordToken("TODO ?????????");
		
		return ResponseEntity.ok(response);
	}
	*/
}
