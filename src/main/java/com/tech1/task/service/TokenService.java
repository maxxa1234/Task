package com.tech1.task.service;

public interface TokenService {

    String createToken(Long userId);
    Long getUserIdFromToken(String token);
    boolean isTokenValid(String token);
}
