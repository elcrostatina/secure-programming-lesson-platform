package it.fdm.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fdm.backend.dto.ValidateTokenDto;
import it.fdm.backend.services.JwtService;
import it.fdm.backend.services.TokenService;

@RestController()
@RequestMapping("/lesson")
public class LessonController {
	
    private final TokenService tokenService;
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    public LessonController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    
    @GetMapping("/{videoId}/")
    @CrossOrigin(origins = "*")
    public String create(@PathVariable String videoId, @RequestHeader RequestHeader req) {
    	
    
        
    	//jwtService.validateAndReadJwt("tokenId");
    	
    	return null;
    	//return tokenService.createToken(params.getLocalName(), params.getDomain());
    }
    
    
    // jwt e il videoId

}
