package it.fdm.backend.services;

import org.springframework.beans.factory.annotation.Autowired;

import it.fdm.backend.utils.JwtTokenUtil;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public String createToken(String user, String domain) {
		return jwtTokenUtil.generateToken(user, domain);
	}

	
}
