package it.fdm.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fdm.backend.entities.CompanyInfo;
import it.fdm.backend.entities.ValidateTokenDto;
import it.fdm.backend.services.MailService;

@RestController
public class StudenteController {
	
	private MailService mailService;
	
	@Autowired
	public StudenteController(MailService mailService) {
		super();
		this.mailService = mailService;
	}

	@GetMapping("/get-company-info")
	public CompanyInfo getCompanyInfo(@RequestParam(value = "ownerId", required = false) String ownerId) {
		this.mailService.sendEmail("chaffner@fdmservices.it", "TEST", "DEBUG");

		CompanyInfo ci = new CompanyInfo(); // TODO: query
		ci.setNome("");
		ci.setDomains(new String[] { "@fdmservices.it", "@tech.fdmservices.it" });

		return ci;
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
