package it.fdm.backend.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JwtService {
    private final String SECRET_KEY = "MY_SUPER_SECRET_UNSAFE_KEY";
    private final String privateKey;

    JwtService(Environment env) {
        this.privateKey = env.getProperty("JWT_PRIVATE_KEY");
    }

    public DecodedJWT validateAndReadJwt(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
            return verifier.verify(token);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

//    public static String create() {
//        try {
//            Algorithm algorithm = Algorithm.RSA256("", "");
//            String token = JWT.create()
//                    .withIssuer("auth0")
//                    .sign(algorithm);
//        } catch (Exception exception){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}