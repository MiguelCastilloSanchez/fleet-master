package com.example.fleetmaster.infrastructure.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    // This method validates and returns the subject from a token. This needs to be transformed
    // Into two methods
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    public String getRoleFromToken(String token) {
        return decodeJWT(token).getClaim("role").asString();
    }

    public String getIdFromToken(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        return decodeJWT(token).getClaim("id").asString();
    }

    private DecodedJWT decodeJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);
        var verifier = JWT.require(algorithm).withIssuer("auth-api").build();
        var decodedJWT = verifier.verify(token);
        return decodedJWT;
    }
}
