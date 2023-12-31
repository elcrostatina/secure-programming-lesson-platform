package it.fdm.backend.rest;

import it.fdm.backend.dto.EntrypointTokenDto;
import it.fdm.backend.dto.PasswordTokenDto;
import it.fdm.backend.dto.ValidateTokenDto;
import it.fdm.backend.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping()
    @CrossOrigin(origins = "*")
    public String create(@RequestBody ValidateTokenDto params) {
        return tokenService.createToken(params.getLocalName(), params.getDomain());
    }

    @PostMapping("/validate")
    @CrossOrigin(origins = "*")
    public PasswordTokenDto create(@RequestBody EntrypointTokenDto params) {
        return tokenService.validateToken(params.getToken(), params.getId());
    }
}
