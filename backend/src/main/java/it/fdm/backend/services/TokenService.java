package it.fdm.backend.services;

import it.fdm.backend.dto.PasswordTokenDto;
import it.fdm.backend.entities.Token;
import it.fdm.backend.repositories.TokenRepository;
import it.fdm.backend.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class TokenService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private TokenRepository tokenRepository;

	public String createToken(String user, String domain) {
		String token = jwtTokenUtil.generateToken();
		String hashedToken = BCrypt.hashpw(token, BCrypt.gensalt());

		Token tokenEntity = new Token();
		tokenEntity.setDomain(domain);
		tokenEntity.setLocalName(user);
		tokenEntity.setToken(hashedToken);

		tokenRepository.save(tokenEntity);

		return "http://localhost:8080/studente?token=" + token + "&id=" + tokenEntity.getId();
	}

	public PasswordTokenDto validateToken(String token, UUID id) {
		Token tokenEntity = tokenRepository.findOneById(id);

		if(!BCrypt.checkpw(token, tokenEntity.getToken())) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token non valido");
		}

		String hashedToken = BCrypt.hashpw(jwtTokenUtil.generateToken(), BCrypt.gensalt());
		tokenEntity.setToken(hashedToken);
		tokenEntity.setState("PASSWORD_CHANGE");
		tokenRepository.save(tokenEntity);

		PasswordTokenDto passwordTokenDto = new PasswordTokenDto();
		passwordTokenDto.setToken(hashedToken);

		return passwordTokenDto;
	}
}
