package com.tech1.task.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tech1.task.service.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

import static java.util.Objects.nonNull;

@Service
public class TokenServiceImpl implements TokenService {
    private final static Logger log = LogManager.getLogger(TokenService.class);

    private static final String TOKEN_SECRET = "TestTask2020";
    private static final String USER_ID = "userId";
    private static final String CREATED_AT = "createdAt";

    @Override
    public String createToken(Long userId) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(TOKEN_SECRET);
            return JWT.create()
                    .withClaim(USER_ID, userId)
                    .withClaim(CREATED_AT, new Date())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            log.error("Error during creation security token", e);
            return null;
        }
    }

    @Override
    public Long getUserIdFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim(USER_ID).asLong();
        } catch (JWTVerificationException e) {
            log.error("Error during parsing security token", e);
            return null;
        }
    }

    @Override
    public boolean isTokenValid(String token) {
        Long userId = this.getUserIdFromToken(token);
        return nonNull(userId);
    }
}
