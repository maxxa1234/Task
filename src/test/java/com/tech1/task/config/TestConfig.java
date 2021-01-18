package com.tech1.task.config;

import com.tech1.task.service.TokenService;
import com.tech1.task.service.impl.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public TokenService tokenService() {
        return new TokenServiceImpl();
    }
}
